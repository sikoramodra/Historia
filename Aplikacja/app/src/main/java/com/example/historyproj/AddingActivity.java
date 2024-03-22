package com.example.historyproj;
import com.google.gson.Gson;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddingActivity extends AppCompatActivity {

    public String name_add_id;
    public String place_add_id;
    public String info_add_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.adding_lay);
        ImageButton homeButton = findViewById(R.id.homebutton);
        ImageButton addPostButton = findViewById(R.id.addpostbutton);
        ImageButton profileButton = findViewById(R.id.profilebutton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddingActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        addPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddingActivity.this, AddingActivity.class);
                startActivity(intent);
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddingActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });


        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataToServer();
            }
        });
    }

        void sendDataToServer() {
            EditText editName;
            EditText editOtherNames;
            EditText editCodeNames;
            EditText editInscription;
            DatePicker editBirthDate;
            EditText editBirthPlace;
            DatePicker editDeathDate;
            EditText editDeathPlace;
            EditText editBurialPlace;
            EditText editCemetery;
            EditText editQuarter;
            EditText editRow;
            EditText editGrave;
            EditText editRanks;
            EditText editBadges;
            EditText editActivity;
            EditText editDescription;
            EditText editSources;
            editName = findViewById(R.id.editName);
            editOtherNames = findViewById(R.id.editOtherNames);
            editCodeNames = findViewById(R.id.editCodeNames);
            editInscription = findViewById(R.id.editInscription);
            editBirthDate = findViewById(R.id.editBirthDate);
            editBirthPlace = findViewById(R.id.editBirthPlace);
            editDeathDate = findViewById(R.id.editDeathDate);
            editDeathPlace = findViewById(R.id.editDeathPlace);
            editBurialPlace = findViewById(R.id.editBurialPlace);
            editCemetery = findViewById(R.id.editCemetery);
            editQuarter = findViewById(R.id.editQuarter);
            editRow = findViewById(R.id.editRow);
            editGrave = findViewById(R.id.editGrave);
            editRanks = findViewById(R.id.editRanks);
            editBadges = findViewById(R.id.editBadges);
            editActivity = findViewById(R.id.editActivity);
            editDescription = findViewById(R.id.editDescription);
            editSources = findViewById(R.id.editSources);
            int year_birth = editBirthDate.getYear();
            int month_birth = (editBirthDate.getMonth() + 1);
            int day_birth = editBirthDate.getDayOfMonth();
            String selectedDate_birth = String.format("%04d-%02d-%02d", year_birth, month_birth, day_birth);
            int year_death = editDeathDate.getYear();
            int month_death = (editDeathDate.getMonth() + 1);
            int day_death = editDeathDate.getDayOfMonth();
            String selectedDate_death = String.format("%04d-%02d-%02d", year_death, month_death, day_death);
            String name = editName.getText().toString();
            String otherNames = editOtherNames.getText().toString();
            String codeNames = editCodeNames.getText().toString();
            String inscription = editInscription.getText().toString();
            String birthDate = selectedDate_birth;
            String birthPlace = editBirthPlace.getText().toString();
            String deathDate = selectedDate_death;
            String deathPlace = editDeathPlace.getText().toString();
            String burialPlace = editBurialPlace.getText().toString();
            String cemetery = editCemetery.getText().toString();
            String quarter = editQuarter.getText().toString();
            String row = editRow.getText().toString();
            String grave = editGrave.getText().toString();
            String ranks = editRanks.getText().toString();
            String badges = editBadges.getText().toString();
            String activity = editActivity.getText().toString();
            String description = editDescription.getText().toString();
            String sources = editSources.getText().toString();
            Person person = new Person();
            person.setName(name);
            person.setOtherNames(Arrays.asList(otherNames.split("\\s*,\\s*")));
            person.setCodeNames(Arrays.asList(codeNames.split("\\s*,\\s*")));
            person.setInscription(inscription);
            person.setBirthDate(birthDate);
            person.setBirthPlace(birthPlace);
            person.setDeathDate(deathDate);
            person.setDeathPlace(deathPlace);
            person.setBurialPlace(burialPlace);
            person.setCemetery(cemetery);
            person.setQuarter(quarter);
            person.setRow(row);
            person.setGrave(grave);
            person.setRanks(ranks);
            person.setBadges(badges);
            person.setActivity(activity);
            person.setDescription(description);
            person.setSources(sources);


            sendPersonToServer(person);
        }
    private void sendPersonToServer(Person person) {
        Gson gson = new Gson();
        String json = gson.toJson(person);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<Void> call = apiService.postPerson(requestBody);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Intent intent = new Intent(AddingActivity.this, PostSentActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(AddingActivity.this, PostNotSentActivity.class);
                    startActivity(intent);
                }
                }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Intent intent = new Intent(AddingActivity.this, PostNotSentActivity.class);
                startActivity(intent);
            }
        });
    }

}