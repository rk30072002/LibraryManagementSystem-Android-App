package com.example.librarymanagmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TransactionsActivity extends AppCompatActivity {
    private Button checkBookButton, issueBookButton, returnBookButton, payFineButton, logOutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);

        checkBookButton = findViewById(R.id.button_check_book);
        issueBookButton = findViewById(R.id.button_issue_book);
        returnBookButton = findViewById(R.id.button_return_book);
        payFineButton = findViewById(R.id.button_pay_fine);
        logOutButton = findViewById(R.id.button_log_out);

        checkBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransactionsActivity.this, CheckBookAvailabilityActivity.class);
                startActivity(intent);
            }
        });
        issueBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransactionsActivity.this, BookAvailableTr.class);
                startActivity(intent);
            }
        });
        returnBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransactionsActivity.this, ReturnBookTr.class);
                startActivity(intent);
            }
        });
        payFineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransactionsActivity.this, Transactions.class);
                startActivity(intent);
            }
        });
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast Toast = null;
                Toast.makeText(TransactionsActivity.this, "Logging out...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TransactionsActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}