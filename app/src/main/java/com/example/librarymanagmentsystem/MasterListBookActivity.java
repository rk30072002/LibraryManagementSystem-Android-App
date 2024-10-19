package com.example.librarymanagmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MasterListBookActivity extends AppCompatActivity {
    private Button masterListBooksButton, masterListMoviesButton, masterListMembershipsButton, logOutButton;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_list_book);

        masterListBooksButton = findViewById(R.id.masterListBooksButton);
        masterListMoviesButton = findViewById(R.id.masterListMoviesButton);
        masterListMembershipsButton = findViewById(R.id.masterListMembershipsButton);
        logOutButton = findViewById(R.id.logOutButton);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        masterListBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MasterListBookActivity.this, MasterListBookActivity.class));
            }
        });

        masterListMoviesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MasterListBookActivity.this, MasterListMovieActivity.class));
            }
        });

        masterListMembershipsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MasterListBookActivity.this, MembershipsActivity.class));
            }
        });

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MasterListBookActivity.this, LoginActivity.class));
                finish();
            }
        });
    }
}