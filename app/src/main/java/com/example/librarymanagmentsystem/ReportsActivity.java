package com.example.librarymanagementsystem;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


import com.example.librarymanagmentsystem.BookAvailableTr;
import com.example.librarymanagmentsystem.IssueBookTransaction;
import com.example.librarymanagmentsystem.LoginActivity;
import com.example.librarymanagmentsystem.MasterListBookActivity;
import com.example.librarymanagmentsystem.MasterListMovieActivity;
import com.example.librarymanagmentsystem.MembershipsActivity;
import com.example.librarymanagmentsystem.OverdueReturn;
import com.example.librarymanagmentsystem.R;
import com.example.librarymanagmentsystem.ReturnBookTr;
import com.example.librarymanagmentsystem.membershipActivity;

public class ReportsActivity extends AppCompatActivity {

    private Button masterListBooksButton, masterListMoviesButton, masterListMembershipsButton;
    private Button activeIssuesButton, overdueReturnsButton, pendingIssueRequestsButton, logOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        masterListBooksButton = findViewById(R.id.masterListBooksButton);
        masterListMoviesButton = findViewById(R.id.masterListMoviesButton);
        masterListMembershipsButton = findViewById(R.id.masterListMembershipsButton);
        activeIssuesButton = findViewById(R.id.activeIssuesButton);
        overdueReturnsButton = findViewById(R.id.overdueReturnsButton);
        pendingIssueRequestsButton = findViewById(R.id.pendingIssueRequestsButton);
        logOutButton = findViewById(R.id.logOutButton);
        masterListBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReportsActivity.this, membershipActivity.class));
            }
        });

        masterListMoviesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReportsActivity.this, MasterListMovieActivity.class));
            }
        });

        masterListMembershipsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReportsActivity.this, MembershipsActivity.class));
            }
        });

        activeIssuesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReportsActivity.this, BookAvailableTr.class));
            }
        });

        overdueReturnsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReportsActivity.this, OverdueReturn.class));
            }
        });

        pendingIssueRequestsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReportsActivity.this, IssueBookTransaction.class));
            }
        });

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle logout (clear session, go to login page)
                startActivity(new Intent(ReportsActivity.this, LoginActivity.class));
                finish();
            }
        });
    }
}
