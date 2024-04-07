package com.example.historyproj;

import static android.widget.Toast.makeText;

import android.content.ContentValues;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class EditPostActivity extends AppCompatActivity {

    private EditText editName;
    private EditText editOtherName;
    private EditText editCodeName;
    private EditText editInscription;
    private EditText editBirthDate;
    private EditText editDeathDate;
    private EditText editBirthPlace;
    private EditText editDeathPlace;
    private EditText editBurialPlace;
    private EditText editCementery;
    private EditText editQuarter;
    private EditText editRow;
    private EditText editGrave;
    private EditText editRanks;
    private EditText editBadges;
    private EditText editDescripiton;
    private EditText editSources;
    private EditText editActivities;

    private Button saveButton;

    private int postId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_edit_post);
        postId = getIntent().getIntExtra("personId", -1);

        editName = findViewById(R.id.editName);
        editOtherName = findViewById(R.id.editOtherNames);
        editCodeName = findViewById(R.id.editCodeNames);
        editBirthPlace = findViewById(R.id.editBirthPlace);
        editBurialPlace = findViewById(R.id.editBurialPlace);
        editInscription = findViewById(R.id.editInscription);
        editDeathPlace = findViewById(R.id.editDeathPlace);
        editBadges = findViewById(R.id.editBadges);
        editSources = findViewById(R.id.editSources);
        editRanks = findViewById(R.id.editRanks);
        editGrave = findViewById(R.id.editGrave);
        editRow = findViewById(R.id.editRow);
        editQuarter = findViewById(R.id.editQuarter);
        editActivities = findViewById(R.id.editActivity);
        editCementery = findViewById(R.id.editCemetery);
        editDescripiton = findViewById(R.id.editDescription);
        saveButton = findViewById(R.id.saveButton);
        fetchPersonDetails(postId);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String othername = editOtherName.getText().toString();
                String codename = editCodeName.getText().toString();
                String inscription = editInscription.getText().toString();
                String birthplace = editBirthPlace.getText().toString();
                String deathplace = editDeathPlace.getText().toString();
                String ranks = editRanks.getText().toString();
                String sources = editSources.getText().toString();
                String description = editDescripiton.getText().toString();
                postId = getIntent().getIntExtra("personId", -1);
                //String cementery = editCementery.getText().toString();
                //String quarter = editQuarter.getText().toString();
                //String row = editRow.getText().toString();
                //String badges = editBadges.getText().toString();
                updatePersonInDatabase(name, othername, codename, inscription, birthplace, deathplace, ranks, description, sources, postId);
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
                    Toast.makeText(EditPostActivity.this, "Failed to fetch person details", Toast.LENGTH_SHORT).show();
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
    private void updatePersonInDatabase(String name, String othername, String codename, String inscription, String birthplace, String deathplace, String ranks, String description, String sources, int personId) {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Person updatedPerson = new Person();
        updatedPerson.setName(name);
        updatedPerson.setOtherNames(Arrays.asList(othername.split("\\s*,\\s*")));
        updatedPerson.setCodeNames(Arrays.asList(codename.split("\\s*,\\s*")));
        updatedPerson.setBirthPlace(birthplace);
        updatedPerson.setDeathPlace(deathplace);
        updatedPerson.setRanks(ranks);
        updatedPerson.setInscription(inscription);
        updatedPerson.setDescription(description);
        updatedPerson.setSources(sources);
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(updatedPerson);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
        Call<List<Person>> call = apiService.updatePerson(personId, requestBody);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    finish();
                } else {
                   Log.e("Error", "prob the begin array issue");
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });


    }
}