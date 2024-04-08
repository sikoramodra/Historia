package com.example.historyproj;

import static android.widget.Toast.makeText;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowPostActivity extends AppCompatActivity {

    private TextView editName;
    private TextView editOtherName;
    private TextView editCodeName;
    private TextView editInscription;
    private TextView editBirthDate;
    private TextView editDeathDate;
    private TextView editBirthPlace;
    private TextView editDeathPlace;
    private TextView editBurialPlace;
    private TextView editCementery;
    private TextView editQuarter;
    private TextView editRow;
    private TextView editGrave;
    private TextView editRanks;
    private TextView editBadges;
    private TextView editDescripiton;
    private TextView editSources;
    private TextView editActivities;

    private Button saveButton;

    private int postId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.item_details);
        postId = getIntent().getIntExtra("personId", -1);
        ImageButton homeButton = findViewById(R.id.homebutton);
        ImageButton addPostButton = findViewById(R.id.addpostbutton);
        ImageButton profileButton = findViewById(R.id.profilebutton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowPostActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        addPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowPostActivity.this, AddingActivity.class);
                startActivity(intent);
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowPostActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        editName = findViewById(R.id.postName);
        editOtherName = findViewById(R.id.postOtherNames);
        editCodeName = findViewById(R.id.postCodeNames);
        editBirthPlace = findViewById(R.id.editBirthPlace);
        editBurialPlace = findViewById(R.id.postBurialPlace);
        editInscription = findViewById(R.id.postInscription);
        editDeathPlace = findViewById(R.id.editDeathPlace);
        editBadges = findViewById(R.id.postBadges);
        editSources = findViewById(R.id.postSources);
        editRanks = findViewById(R.id.editRanks);
        editGrave = findViewById(R.id.editGrave);
        editRow = findViewById(R.id.editRow);
        editQuarter = findViewById(R.id.editQuarter);
        editActivities = findViewById(R.id.postActivity);
        editCementery = findViewById(R.id.postCemetery);
        editDescripiton = findViewById(R.id.postDescription);
        saveButton = findViewById(R.id.backButton);
        fetchPersonDetails(postId);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void fetchPersonDetails(int postId) {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<Person> call = apiService.detailsPerson(postId);
        call.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                if (response.isSuccessful()) {
                    Person person = response.body();
                    if (person != null) {
                        if (person.getName() != null && !person.getName().isEmpty()) {
                            editName.setText(person.getName());
                        }
                        if (person.getInscription() != null && !person.getInscription().isEmpty()) {
                            editInscription.setText(person.getInscription());
                        }
                        if (person.getOtherNames() != null && !person.getOtherNames().isEmpty()) {
                            editOtherName.setText(listToString(person.getOtherNames()));
                        }
                        if (person.getDeathPlace() != null && !person.getDeathPlace().isEmpty()) {
                            editDeathPlace.setText(person.getDeathPlace());
                        }
                        if (person.getBirthPlace() != null && !person.getBirthPlace().isEmpty()) {
                            editBirthPlace.setText(person.getBirthPlace());
                        }
                        if (person.getDescription() != null && !person.getDescription().isEmpty()) {
                            editDescripiton.setText(person.getDescription());
                        }
                        if (person.getRanks() != null && !person.getRanks().isEmpty()) {
                            editRanks.setText(person.getRanks());
                        }
                        if (person.getSources() != null && !person.getSources().isEmpty()) {
                            editSources.setText(person.getSources());
                        }
                        if (person.getCodeNames() != null && !person.getCodeNames().isEmpty()) {
                            editCodeName.setText(listToString(person.getCodeNames()));
                        }
                        if (person.getCemetery() != null && !person.getCemetery().isEmpty()) {
                            editCementery.setText(person.getCemetery());
                        }
                        if (person.getBurialPlace() != null && !person.getBurialPlace().isEmpty()) {
                            editBurialPlace.setText(person.getBurialPlace());
                        }
                        if (person.getQuarter() != null && !person.getQuarter().isEmpty()) {
                            editQuarter.setText(person.getQuarter());
                        }
                        if (person.getRow() != null && !person.getRow().isEmpty()) {
                            editRow.setText(person.getRow());
                        }
                        if (person.getGrave() != null && !person.getGrave().isEmpty()) {
                            editGrave.setText(person.getGrave());
                        }
                    }
                } else {
                    Toast.makeText(ShowPostActivity.this, "Failed to fetch person details", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }
    private String listToString(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        if (list != null && !list.isEmpty()) {
            for (String item : list) {
                stringBuilder.append(item).append(", ");
            }
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        return stringBuilder.toString();
    }

}
