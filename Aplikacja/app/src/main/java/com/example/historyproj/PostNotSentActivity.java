package com.example.historyproj;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class PostNotSentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.postnotsent);
}}
