package com.example.librarymanagmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MembershipsActivity extends AppCompatActivity {
    Button backButton, confirmButton, logOutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberships);

        backButton = findViewById(R.id.backButton);
        confirmButton = findViewById(R.id.confirmButton);
        logOutButton = findViewById(R.id.logOutButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // onBackPressed();
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle confirm action, like saving changes to database
                // You can call Firebase functions or other actions here
            }
        });

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MembershipsActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}