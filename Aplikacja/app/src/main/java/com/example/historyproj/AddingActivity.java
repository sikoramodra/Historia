package com.example.historyproj;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class AddingActivity extends AppCompatActivity {
    public String name_add_id;
    public String place_add_id;
    public String info_add_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adding_lay);
        EditText setname = findViewById(R.id.Name_add);
        EditText setplace = findViewById(R.id.Place_add);
        EditText setinfo = findViewById(R.id.info_add);

        try {
            String nam_f = getIntent().getStringExtra("EXTRA_NAME_F");
            String pla_f = getIntent().getStringExtra("EXTRA_PLACE_F");
            String inf_f = getIntent().getStringExtra("EXTRA_INFO_F");
            setname.setText(nam_f);
            setplace.setText(pla_f);
            setinfo.setText(inf_f);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageButton homeButton = findViewById(R.id.homebutton);
        ImageButton addPostButton = findViewById(R.id.addpostbutton);
        ImageButton profileButton = findViewById(R.id.profilebutton);
        Button pickfiltersbutton = findViewById(R.id.pickfilters);
        Button sendPost = findViewById(R.id.sendpost);

        pickfiltersbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_add_id = setname.getText().toString();
                place_add_id = setplace.getText().toString();
                info_add_id = setinfo.getText().toString();
                Intent intent = new Intent(AddingActivity.this, FiltersActivity.class);
                intent.putExtra("EXTRA_NAME", name_add_id);
                intent.putExtra("EXTRA_PLACE", place_add_id);
                intent.putExtra("EXTRA_INFO", info_add_id);
                startActivity(intent);
            }
        });

        sendPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_add_id = setname.getText().toString();
                place_add_id = setplace.getText().toString();
                info_add_id = setinfo.getText().toString();
                saveDataToFile(name_add_id, place_add_id, info_add_id);

                Intent intent = new Intent(AddingActivity.this, PostSentActivity.class);
                startActivity(intent);
            }
        });

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
    }

    private void saveDataToFile(String name, String place, String info) {
        try {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", name);
            jsonObject.put("place", place);
            jsonObject.put("info", info);


            String jsonData = jsonObject.toString();
            AssetManager assetManager = getAssets();
            InputStream inputStream = assetManager.open("adding_data.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder fileContents = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                fileContents.append(line).append("\n");
            }
            reader.close();
            fileContents.append(jsonData.getBytes()).append("\n");
            OutputStream outputStream = openFileOutput("adding_data.txt", MODE_PRIVATE);
            outputStream.write(fileContents.toString().getBytes());
            outputStream.close();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
