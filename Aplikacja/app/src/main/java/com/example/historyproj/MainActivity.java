package com.example.historyproj;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.historyproj.R;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private String username;
    private String password;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);

        dbHelper = new DbHelper(this);

        //usernameEditText = findViewById(R.id.usernameEditText);
        //passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);
        Button Rejestrator = findViewById(R.id.Register);
        Button Gosc = findViewById(R.id.guest);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleLogin();
            }
        });

        Rejestrator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleRegistration();
            }
        });

        Gosc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleGuestLogin();
            }
        });
    }

    private void handleLogin() {
        username = usernameEditText.getText().toString();
        password = passwordEditText.getText().toString();

        if (login(username, password)) {
            Log.e(username, password);
            Toast.makeText(MainActivity.this, "Zalogowano", Toast.LENGTH_SHORT).show();
            sendToHome();
        } else {
            Toast.makeText(MainActivity.this, "Login lub hasło nie istnieje.", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleRegistration() {
        String newUsername = usernameEditText.getText().toString();
        String newPassword = passwordEditText.getText().toString();
        registerUser(newUsername, newPassword);
        Toast.makeText(MainActivity.this, "Zarejestrowano pomyślnie" + newUsername + newPassword, Toast.LENGTH_SHORT).show();
    }

    private void handleGuestLogin() {
        username = "guest";
        password = "guest";
        Toast.makeText(MainActivity.this, username + password, Toast.LENGTH_SHORT).show();
        sendToHome();
    }

    private boolean login(String username, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] columns = {"username", "password"};
        String selection = "username = ? AND password = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query("users", columns, selection, selectionArgs, null, null, null);

        boolean isValid = cursor.getCount() > 0;
        cursor.close();
        return isValid;
    }

    private void registerUser(String username, String password) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);

        db.insert("users", null, values);
    }

    private void sendToHome() {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}