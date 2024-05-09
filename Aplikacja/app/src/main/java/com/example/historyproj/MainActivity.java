package com.example.historyproj;

import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);


        //usernameEditText = findViewById(R.id.usernameEditText);
        //passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);
        Button Rejestrator = findViewById(R.id.Register);
        Button Gosc = findViewById(R.id.guest);



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


    private void handleRegistration() {
        String newUsername = usernameEditText.getText().toString();
        String newPassword = passwordEditText.getText().toString();
        Toast.makeText(MainActivity.this, "Zarejestrowano pomyślnie" + newUsername + newPassword, Toast.LENGTH_SHORT).show();
    }

    private void handleGuestLogin() {
        username = "guest";
        password = "guest";
        Toast.makeText(MainActivity.this, username + password, Toast.LENGTH_SHORT).show();
        sendToHome();
    }



    private void sendToHome() {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}