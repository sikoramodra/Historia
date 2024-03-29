package com.example.historyproj;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
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
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeactivity_lay);
        getSupportActionBar().hide();

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.allposts_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize Retrofit API service
        ApiService apiService = ApiClient.getClient().create(ApiService.class);

        // Call API method to fetch data
        Call<List<Person>> call = apiService.getData();
        call.enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                if (response.isSuccessful()) {
                    // Fetch the list of persons
                    List<Person> people = response.body();
                    // Set up the RecyclerView adapter
                    personAdapter = new PersonAdapter(people);
                    recyclerView.setAdapter(personAdapter);
                } else {
                    // Handle unsuccessful response
                    Toast.makeText(HomeActivity.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                // Handle failure
                Toast.makeText(HomeActivity.this, "Failed to fetch data: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        searchView = findViewById(R.id.search_view);
        int searchPlateId = searchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        TextView searchPlate = searchView.findViewById(searchPlateId);
        searchPlate.setTextColor(Color.WHITE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                personAdapter.filter(newText);
                return true;
            }
        });

        // Set up onClick listeners for buttons
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
