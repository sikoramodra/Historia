package com.example.historyproj;
import com.google.gson.Gson;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AddingActivity extends AppCompatActivity {

    public String name_add_id;
    public String place_add_id;
    public String info_add_id;
    private LinearLayout mainLayout;
    private ApiService apiService;
    private String selectedMainName;
    private String selectedSubName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.adding_lay);
        ImageButton homeButton = findViewById(R.id.goback);
        Button saveButton = findViewById(R.id.saveButton);
        Button savebt2 = findViewById(R.id.savebt2);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddingActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataToServer();
            }
        });
        savebt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataToServer();
            }
        });
        //mainLayout = findViewById(R.id.mainLayout);
        Retrofit retrofit = ApiClient.getClient();
        apiService = retrofit.create(ApiService.class);
    }
    void sendDataToServer () {
        EditText editName = findViewById(R.id.editName);
        EditText editOtherNames = findViewById(R.id.editOtherNames);
        EditText editCodeNames = findViewById(R.id.editCodeNames);
        EditText editInscription = findViewById(R.id.editInscription);
        EditText editBirthPlace = findViewById(R.id.editBirthPlace);
        EditText editDeathPlace = findViewById(R.id.editDeathPlace);
        EditText editBurialPlace = findViewById(R.id.editBurialPlace);
        EditText editCemetery = findViewById(R.id.editCementeryPlace);
        EditText editQuarter = findViewById(R.id.editQuarter);
        EditText editRow = findViewById(R.id.editRow);
        EditText editGrave = findViewById(R.id.editGrave);
        //EditText editRanks = findViewById(R.id.editRanks);
        //EditText editBadges = findViewById(R.id.editBadges);
        //EditText editActivity = findViewById(R.id.editActivity);
        EditText editDescription = findViewById(R.id.editDescription);
        EditText editSources = findViewById(R.id.editDescription);
        EditText editBirthday = findViewById(R.id.editBirthDay);
        EditText editBirthmonth = findViewById(R.id.editBirthMonth);
        EditText editBirthyear = findViewById(R.id.editBirthYear);
        String selectedDate_birth = null;
        if (editBirthyear.length() > 0 && editBirthmonth.length() > 0 && editBirthday.length() > 0) {
            int birthYear = Integer.parseInt(editBirthyear.getText().toString());
            int birthMonth = Integer.parseInt(editBirthmonth.getText().toString());
            int birthDay = Integer.parseInt(editBirthday.getText().toString());
            selectedDate_birth = String.format("%04d-%02d-%02d", birthYear, birthMonth, birthDay);
        }
        EditText editDeathDay = findViewById(R.id.editDeathDay);
        EditText editDeathMonth = findViewById(R.id.editDeathMonth);
        EditText editDeathYear = findViewById(R.id.editDeathYear);
        String selectedDate_death = null;
        if (editDeathYear.length() > 0 && editDeathMonth.length() > 0 && editDeathDay.length() > 0) {
            int deathYear = Integer.parseInt(editDeathYear.getText().toString());
            int deathMonth = Integer.parseInt(editDeathMonth.getText().toString());
            int deathDay = Integer.parseInt(editDeathDay.getText().toString());
            selectedDate_death = String.format("%04d-%02d-%02d", deathYear, deathMonth, deathDay);
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
        //String ranks = editRanks.getText().toString();
        String description = editDescription.getText().toString();
        String sources = editSources.getText().toString();
        if (!name.isEmpty() || !otherNames.isEmpty() || !codeNames.isEmpty()) {
            Person person = new Person();
            person.setName(name);
            person.setOtherNames(Arrays.asList(otherNames.split("\\s*,\\s*")));
            person.setCodeNames(Arrays.asList(codeNames.split("\\s*,\\s*")));
            person.setInscription(inscription);
            if (selectedDate_birth != null) {
                person.setBirthDate(selectedDate_birth);
            }
            if (selectedDate_death != null) {
                person.setDeathDate(selectedDate_death);
            }
            person.setBirthPlace(birthPlace);
            person.setDeathPlace(deathPlace);
            person.setBurialPlace(burialPlace);
            person.setCemetery(cemetery);
            person.setQuarter(quarter);
            person.setRow(row);
            person.setGrave(grave);
            //person.setRanks(ranks);
            person.setDescription(description);
            person.setSources(sources);
            sendPersonToServer(person);
        }
        else{

        }
    }

    private void sendPersonToServer (Person person){
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
                } else {
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