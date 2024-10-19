package com.example.librarymanagmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class BookAvailableTr extends AppCompatActivity {

    private Spinner bookSpinner, authorSpinner;
    private EditText fineAmountInput;
    private Button checkAvailabilityButton, issueBookButton, returnBookButton, payFineButton, logOutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_available_tr);

        bookSpinner = findViewById(R.id.spinner_book_name);
        authorSpinner = findViewById(R.id.spinner_author_name);
        fineAmountInput = findViewById(R.id.editText_fine_amount);

        checkAvailabilityButton = findViewById(R.id.button_check_availability);
        issueBookButton = findViewById(R.id.button_issue_book);
        returnBookButton = findViewById(R.id.button_return_book);
        payFineButton = findViewById(R.id.button_pay_fine);
        logOutButton = findViewById(R.id.button_log_out);

        checkAvailabilityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBookAvailability();
            }
        });
        issueBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                issueBook();
            }
        });

        returnBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnBook();
            }
        });

        payFineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payFine();
            }
        });

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOut();
            }
        });
    }
    private void checkBookAvailability() {
        Toast.makeText(this, "Checking book availability", Toast.LENGTH_SHORT).show();
    }
    private void issueBook() {
        String selectedBook = bookSpinner.getSelectedItem().toString();
        if (selectedBook.isEmpty()) {
            Toast.makeText(this, "Please select a book to issue", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Book issued: " + selectedBook, Toast.LENGTH_SHORT).show();
    }
    private void returnBook() {
        String selectedAuthor = authorSpinner.getSelectedItem().toString();
        if (selectedAuthor.isEmpty()) {
            Toast.makeText(this, "Please select an author", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Book returned by author: " + selectedAuthor, Toast.LENGTH_SHORT).show();
    }
    private void payFine() {
        String fineAmount = fineAmountInput.getText().toString();
        if (fineAmount.isEmpty()) {
            Toast.makeText(this, "Please enter fine amount", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Fine paid: " + fineAmount, Toast.LENGTH_SHORT).show();
    }
    private void logOut() {
        Toast.makeText(this, "Logging out...", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(BookAvailableTr.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}