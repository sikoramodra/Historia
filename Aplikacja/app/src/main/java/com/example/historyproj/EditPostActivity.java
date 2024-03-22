package com.example.historyproj;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EditPostActivity extends AppCompatActivity {

    private EditText editName;
    private EditText editPlace;
    private EditText editInfo;
    private Button saveButton;

    private int postId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_edit_post);

        editName = findViewById(R.id.editName);
        //editPlace = findViewById(R.id.editPlace);
        //editInfo = findViewById(R.id.editInfo);
        saveButton = findViewById(R.id.backButton);

        // Otrzymaj dane przekazane z PostAdapter
        postId = getIntent().getIntExtra("POST_ID", -1);
        String postName = getIntent().getStringExtra("POST_NAME");
        String postPlace = getIntent().getStringExtra("POST_PLACE");
        String postInfo = getIntent().getStringExtra("POST_INFO");

        // Ustaw pola tekstowe na istniejące wartości posta
        editName.setText(postName);
        editPlace.setText(postPlace);
        editInfo.setText(postInfo);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Po kliknięciu przycisku "Zapisz", zaktualizuj post
                updatePost();
            }
        });
    }

    private void updatePost() {
        // Odczytaj wartości z pól edycyjnych
        String updatedName = editName.getText().toString().trim();
        String updatedPlace = editPlace.getText().toString().trim();
        String updatedInfo = editInfo.getText().toString().trim();

        // Sprawdź, czy pola są niepuste
        if (updatedName.isEmpty() || updatedPlace.isEmpty() || updatedInfo.isEmpty()) {
            Toast.makeText(this, "Wszystkie pola muszą być wypełnione", Toast.LENGTH_SHORT).show();
            return;
        }


        // Wyświetl komunikat o sukcesie
        Toast.makeText(this, "Post zaktualizowany", Toast.LENGTH_SHORT).show();

        // Zakończ aktywność
        finish();
    }
}
