package com.example.librarymanagmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserActivity extends AppCompatActivity {

    Button masterListBooksButton, masterListMoviesButton, masterListMembershipsButton, activeIssuesButton;
    Button overdueReturnsButton, issueRequestsButton, backButton, logOutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        masterListBooksButton = findViewById(R.id.masterListBooksButton);
        masterListMoviesButton = findViewById(R.id.masterListMoviesButton);
        masterListMembershipsButton = findViewById(R.id.masterListMembershipsButton);
        activeIssuesButton = findViewById(R.id.activeIssuesButton);
        overdueReturnsButton = findViewById(R.id.overdueReturnsButton);
        issueRequestsButton = findViewById(R.id.issueRequestsButton);
        backButton = findViewById(R.id.backButton);
        logOutButton = findViewById(R.id.logOutButton);

        masterListBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserActivity.this, MasterListBookActivity.class);
                startActivity(intent);
            }
        });

        masterListMoviesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserActivity.this, MasterListMovieActivity.class);
                startActivity(intent);
            }
        });

        masterListMembershipsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserActivity.this, MembershipsActivity.class);
                startActivity(intent);
            }
        });

        activeIssuesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserActivity.this, BookAvailableTr.class);
                startActivity(intent);
            }
        });

        overdueReturnsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserActivity.this, OverdueReturn.class);
                startActivity(intent);
            }
        });

        issueRequestsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserActivity.this, IssueBookTransaction.class);
                startActivity(intent);
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, UserActivity.class);
                startActivity(intent);
               // onBackPressed();
            }
        });

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}