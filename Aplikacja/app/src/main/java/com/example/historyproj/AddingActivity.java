package com.example.historyproj;
import com.example.historyproj.DbHelper;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class AddingActivity extends AppCompatActivity {

    public String name_add_id;
    public String place_add_id;
    public String info_add_id;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.adding_lay);

        dbHelper = new DbHelper(this);

        EditText setname = findViewById(R.id.Name_add);
        setname.setText(name_add_id);

        EditText setplace = findViewById(R.id.Place_add);
        setplace.setText(place_add_id);

        EditText setinfo = findViewById(R.id.info_add);
        setinfo.setText(info_add_id);

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
                startActivity(intent);
            }
        });

        sendPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_add_id = setname.getText().toString();
                place_add_id = setplace.getText().toString();
                info_add_id = setinfo.getText().toString();

                // Insert data into the database
                insertDataToDatabase(name_add_id, place_add_id, info_add_id);

                // Navigate to PostSentActivity or perform other actions as needed
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

    private void insertDataToDatabase(String name, String place, String info) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DbHelper.COLUMN_POST_NAME, name);
        values.put(DbHelper.COLUMN_POST_PLACE, place);
        values.put(DbHelper.COLUMN_POST_INFO, info);

        long newRowId = db.insert(DbHelper.TABLE_POSTS, null, values);
        if (newRowId == -1) {
            Toast.makeText(AddingActivity.this, "Error inserting data into the database", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(AddingActivity.this, "Data inserted into the database", Toast.LENGTH_SHORT).show();
        }
    }
}