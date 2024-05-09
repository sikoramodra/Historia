package com.example.historyproj;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.historyproj.Person;
import com.example.historyproj.ApiClient;
import com.example.historyproj.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PersonAdapter personAdapter;
    private EditText searchView;
    private View loadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeactivity_lay);
        getSupportActionBar().hide();
        recyclerView = findViewById(R.id.allposts_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inflate the loading layout
        LayoutInflater inflater = LayoutInflater.from(this);
        loadingView = inflater.inflate(R.layout.loading_layout, null);
        loadingView.setVisibility(View.VISIBLE);

        // Add the loading layout to the root layout
        addContentView(loadingView, new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.MATCH_PARENT));

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<List<Person>> call = apiService.getData();
        call.enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                loadingView.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    List<Person> people = response.body();
                    personAdapter = new PersonAdapter(people);
                    recyclerView.setAdapter(personAdapter);
                } else {
                    Toast.makeText(HomeActivity.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                loadingView.setVisibility(View.GONE);
                Toast.makeText(HomeActivity.this, "Failed to fetch data: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println(t.getMessage());
            }
        });

        searchView = findViewById(R.id.search_view);
        searchView.setTextColor(Color.WHITE);
        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // This method is called before the text is changed.
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // This method is called whenever the text changes.
                String query = charSequence.toString().trim();
                if (personAdapter != null) {
                    personAdapter.filter(query);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // This method is called after the text is changed.
            }
        });

        ImageButton homeButton = findViewById(R.id.homebutton);
        ImageButton addPostButton = findViewById(R.id.addpostbutton);
        ImageButton profileButton = findViewById(R.id.profilebutton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        addPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, AddingActivity.class);
                startActivity(intent);
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
