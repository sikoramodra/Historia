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
            EditText editName = findViewById(R.id.editName);
            EditText editOtherNames = findViewById(R.id.editOtherNames);
            EditText editCodeNames = findViewById(R.id.editCodeNames);
            EditText editInscription = findViewById(R.id.editInscription);
            EditText editBirthPlace = findViewById(R.id.editBirthPlace);
            EditText editDeathPlace = findViewById(R.id.editDeathPlace);
            EditText editBurialPlace = findViewById(R.id.editBurialPlace);
            EditText editCemetery = findViewById(R.id.editCemetery);
            EditText editQuarter = findViewById(R.id.editQuarter);
            EditText editRow = findViewById(R.id.editRow);
            EditText editGrave = findViewById(R.id.editGrave);
            EditText editRanks = findViewById(R.id.editRanks);
            EditText editBadges = findViewById(R.id.editBadges);
            EditText editActivity = findViewById(R.id.editActivity);
            EditText editDescription = findViewById(R.id.editDescription);
            EditText editSources = findViewById(R.id.editSources);
            EditText editBirthday = findViewById(R.id.EditBirthDay);
            EditText editBirthmonth = findViewById(R.id.EditBirthMonth);
            EditText editBirthyear = findViewById(R.id.EditBirthYear);
            String selectedDate_birth = null;
            if(editBirthyear.length() > 0 && editBirthmonth.length() > 0 && editBirthday.length() > 0) {
                int birthYear = Integer.parseInt(editBirthyear.getText().toString());
                int birthMonth = Integer.parseInt(editBirthmonth.getText().toString());
                int birthDay = Integer.parseInt(editBirthday.getText().toString());
                selectedDate_birth = String.format("%04d-%02d-%02d", birthYear, birthMonth, birthDay);
            }
            EditText editDeathDay = findViewById(R.id.EditDeathDay);
            EditText editDeathMonth = findViewById(R.id.EditDeathMonth);
            EditText editDeathYear = findViewById(R.id.EditDeathYear);
            String selectedDate_death = null;
            if(editDeathYear.length() > 0 && editDeathMonth.length() > 0 && editDeathDay.length() > 0) {
                int deathYear = Integer.parseInt(editDeathYear.getText().toString());
                int deathMonth = Integer.parseInt(editDeathMonth.getText().toString());
                int deathDay = Integer.parseInt(editDeathDay.getText().toString());
                selectedDate_death = String.format("%04d-%02d-%02d", editDeathYear, editDeathMonth, editDeathDay);
            }
            String name = editName.getText().toString();
            String otherNames = editOtherNames.getText().toString();
            String codeNames = editCodeNames.getText().toString();
            String inscription = editInscription.getText().toString();
            String birthPlace = editBirthPlace.getText().toString();
            String deathPlace = editDeathPlace.getText().toString();
            String burialPlace = editBurialPlace.getText().toString();
            String cemetery = editCemetery.getText().toString();
            String quarter = editQuarter.getText().toString();
            String row = editRow.getText().toString();
            String grave = editGrave.getText().toString();
            String ranks = editRanks.getText().toString();
            //String badges = editBadges.getText().toString();
            //String activity = editActivity.getText().toString();
            String description = editDescription.getText().toString();
            String sources = editSources.getText().toString();
            Person person = new Person();
            person.setName(name);
            person.setOtherNames(Arrays.asList(otherNames.split("\\s*,\\s*")));
            person.setCodeNames(Arrays.asList(codeNames.split("\\s*,\\s*")));
            person.setInscription(inscription);
            person.setBirthDate(selectedDate_birth);
            person.setBirthPlace(birthPlace);
            person.setDeathDate(selectedDate_death);
            person.setDeathPlace(deathPlace);
            person.setBurialPlace(burialPlace);
            person.setCemetery(cemetery);
            person.setQuarter(quarter);
            person.setRow(row);
            person.setGrave(grave);
            person.setRanks(ranks);
            //person.setBadges(badges);
            //person.setActivity(activity);
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