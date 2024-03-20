package com.example.historyproj;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FiltersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.filters_lay);
        Button bgoback = findViewById(R.id.backtopost);
        String nam = getIntent().getStringExtra("EXTRA_NAME");
        String pla = getIntent().getStringExtra("EXTRA_PLACE");
        String inf = getIntent().getStringExtra("EXTRA_INFO");

        bgoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FiltersActivity.this, AddingActivity.class);
                intent.putExtra("EXTRA_NAME_F", nam);
                intent.putExtra("EXTRA_PLACE_F", pla);
                intent.putExtra("EXTRA_INFO_F", inf);
                startActivity(intent);
            }
        });
    }
}
