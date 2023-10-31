package com.example.historyproj;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.historyproj.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    public EditText usernameEditText;
    public EditText passwordEditText;
    public String username;
    public String password;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);
        Button Rejestrator = findViewById(R.id.Register);
        Button Gosc = findViewById(R.id.guest);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = usernameEditText.getText().toString();
                password = passwordEditText.getText().toString();

                if (username.length() >= 5 && password.length() >= 5) {
                    if (login(username, password)) {
                        Log.e(username, password);
                        Toast.makeText(MainActivity.this, "Zalogowano", Toast.LENGTH_SHORT).show();
                        SendToHome();
                    } else {
                        Toast.makeText(MainActivity.this, "Login lub hasło nie istnieje.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Login i hasło muszą mieć co najmniej 5 znaków.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Rejestrator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.length() >= 5 && password.length() >= 5) {
                    Rejestrator(username, password);
                    Toast.makeText(MainActivity.this, "Zarejestrowano pomyślnie" + username + password, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login i hasło muszą mieć co najmniej 5 znaków.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Gosc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = "guest";
                password = "guest";
                Toast.makeText(MainActivity.this,  username + password, Toast.LENGTH_SHORT).show();
                SendToHome();
            }
        });
    }

    private boolean login(String username, String password) {
        try {
            AssetManager assetManager = getAssets();
            InputStream inputStream = assetManager.open("logowanie.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String storedUsername = parts[0].trim();
                    String storedPassword = parts[1].trim();
                    if (username.equals(storedUsername) && password.equals(storedPassword)) {
                        return true;
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    private void Rejestrator(String username, String password) {
        try {
            AssetManager assetManager = getAssets();
            InputStream inputStream = assetManager.open("logowanie.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder fileContents = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                fileContents.append(line).append("\n");
            }
            reader.close();
            fileContents.append(username).append(":").append(password).append("\n");
            OutputStream outputStream = openFileOutput("logowanie.txt", MODE_PRIVATE);
            outputStream.write(fileContents.toString().getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void SendToHome(){
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
