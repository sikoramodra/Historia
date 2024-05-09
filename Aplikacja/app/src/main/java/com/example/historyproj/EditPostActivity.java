package com.example.historyproj;

import static android.widget.Toast.makeText;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.Calendar;
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
    private EditText editBirthDay;
    private EditText editBirthMonth;
    private EditText editBirthYear;
    private EditText editDeathDay;
    private EditText editDeathMonth;
    private EditText editDeathYear;
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
    private ImageButton goback;
    private Button saveButton;
    private Button savebt2;

    private int postId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_edit_post);
        postId = getIntent().getIntExtra("personId", -1);
        savebt2 = findViewById(R.id.savebt2);
        editName = findViewById(R.id.editName);
        editOtherName = findViewById(R.id.editOtherNames);
        editCodeName = findViewById(R.id.editCodeNames);
        editBirthPlace = findViewById(R.id.editBirthPlace);
        editBurialPlace = findViewById(R.id.editBurialPlace);
        editInscription = findViewById(R.id.editInscription);
        editDeathPlace = findViewById(R.id.editDeathPlace);
        //editBadges = findViewById(R.id.editBadges);
        editSources = findViewById(R.id.editSources);
        //editRanks = findViewById(R.id.editRanks);
        editGrave = findViewById(R.id.editGrave);
        editRow = findViewById(R.id.editRow);
        editQuarter = findViewById(R.id.editQuarter);
        editBirthDay = findViewById(R.id.editBirthDay);
        editBirthMonth = findViewById(R.id.editBirthMonth);
        editBirthYear = findViewById(R.id.editBirthYear);
        editDeathDay = findViewById(R.id.editDeathDay);
        editDeathMonth = findViewById(R.id.editDeathMonth);
        editDeathYear = findViewById(R.id.editDeathYear);
        //editActivities = findViewById(R.id.editActivity);
        editCementery = findViewById(R.id.editCementeryPlace);
        editDescripiton = findViewById(R.id.editDescription);
        saveButton = findViewById(R.id.saveButton);
        goback = findViewById(R.id.goback);
        fetchPersonDetails(postId);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditPostActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String othername = editOtherName.getText().toString();
                String codename = editCodeName.getText().toString();
                String inscription = editInscription.getText().toString();
                String birthplace = editBirthPlace.getText().toString();
                String deathplace = editDeathPlace.getText().toString();
                //String ranks = editRanks.getText().toString();
                String sources = editSources.getText().toString();
                String description = editDescripiton.getText().toString();
                postId = getIntent().getIntExtra("personId", -1);
                //String cementery = editCementery.getText().toString();
                //String quarter = editQuarter.getText().toString();
                //String row = editRow.getText().toString();
                //String badges = editBadges.getText().toString();
                updatePersonInDatabase(name, othername, codename, inscription, birthplace, deathplace, description, sources, postId);
            }
        });
        savebt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String othername = editOtherName.getText().toString();
                String codename = editCodeName.getText().toString();
                String inscription = editInscription.getText().toString();
                String birthplace = editBirthPlace.getText().toString();
                String deathplace = editDeathPlace.getText().toString();
                //String ranks = editRanks.getText().toString();
                String sources = editSources.getText().toString();
                String description = editDescripiton.getText().toString();
                postId = getIntent().getIntExtra("personId", -1);
                //String cementery = editCementery.getText().toString();
                //String quarter = editQuarter.getText().toString();
                //String row = editRow.getText().toString();
                //String badges = editBadges.getText().toString();
                updatePersonInDatabase(name, othername, codename, inscription, birthplace, deathplace, description, sources, postId);
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
                        if (person.getBirthDate() != null) {
                            String[] birthDateParts = person.getBirthDate().split("-");
                            if (birthDateParts.length == 3) {
                                editBirthDay.setText(birthDateParts[2]);
                                editBirthMonth.setText(birthDateParts[1]);
                                editBirthYear.setText(birthDateParts[0]);
                            }
                        }
                        if (person.getDeathDate() != null) {
                            String[] deathDateParts = person.getDeathDate().split("-");
                            if (deathDateParts.length == 3) {
                                editDeathDay.setText(deathDateParts[2]);
                                editDeathMonth.setText(deathDateParts[1]);
                                editDeathYear.setText(deathDateParts[0]);
                            }
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
    private void showNotification(String message) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show();
    }

    private int getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    private int getCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }

    private int getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
    private String getFormattedDate(EditText dayEditText, EditText monthEditText, EditText yearEditText) {
        int day = Integer.parseInt(dayEditText.getText().toString());
        int month = Integer.parseInt(monthEditText.getText().toString());
        int year = Integer.parseInt(yearEditText.getText().toString());
        return String.format("%04d-%02d-%02d", year, month, day);
    }
    private void updatePersonInDatabase(String name, String othername, String codename, String inscription, String birthplace, String deathplace, String description, String sources, int personId) {
        int birthDay = Integer.parseInt(editBirthDay.getText().toString());
        int birthMonth = Integer.parseInt(editBirthMonth.getText().toString());
        int birthYear = Integer.parseInt(editBirthYear.getText().toString());
        String birthDate = getFormattedDate(editBirthDay, editBirthMonth, editBirthYear);
        String deathDate = getFormattedDate(editDeathDay, editDeathMonth, editDeathYear);
        int deathDay = Integer.parseInt(editDeathDay.getText().toString());
        int deathMonth = Integer.parseInt(editDeathMonth.getText().toString());
        int deathYear = Integer.parseInt(editDeathYear.getText().toString());
        if (birthDay < 1 || birthDay > 31 || birthMonth < 1 || birthMonth > 12 ||
                deathDay < 1 || deathDay > 31 || deathMonth < 1 || deathMonth > 12) {
            showNotification("Invalid day or month.");
            return;
        }
        if (birthYear > deathYear || (birthYear == deathYear && birthMonth > deathMonth) ||
                (birthYear == deathYear && birthMonth == deathMonth && birthDay > deathDay)) {
            showNotification("Birth date must be before death date.");
            return;
        }
        if (birthYear > getCurrentYear() || (birthYear == getCurrentYear() && birthMonth > getCurrentMonth()) ||
                (birthYear == getCurrentYear() && birthMonth == getCurrentMonth() && birthDay > getCurrentDay())) {
            showNotification("Birth date cannot be in the future.");
            return;
        }
        if (deathYear > getCurrentYear() || (deathYear == getCurrentYear() && deathMonth > getCurrentMonth()) ||
                (deathYear == getCurrentYear() && deathMonth == getCurrentMonth() && deathDay > getCurrentDay())) {
            showNotification("Death date cannot be in the future.");
            return;
        }
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Person updatedPerson = new Person();
        updatedPerson.setName(name);
        updatedPerson.setOtherNames(Arrays.asList(othername.split("\\s*,\\s*")));
        updatedPerson.setCodeNames(Arrays.asList(codename.split("\\s*,\\s*")));
        updatedPerson.setBirthPlace(birthplace);
        updatedPerson.setDeathPlace(deathplace);
        //updatedPerson.setRanks(ranks);
        updatedPerson.setInscription(inscription);
        updatedPerson.setDescription(description);
        updatedPerson.setBirthDate(birthDate);
        updatedPerson.setDeathDate(deathDate);
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
