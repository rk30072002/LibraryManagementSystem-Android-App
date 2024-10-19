package com.example.librarymanagmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class Transactions extends AppCompatActivity {
    private EditText bookNameInput, authorNameInput, serialNoInput, fineCalculatedInput, remarksInput;
    private DatePicker issueDatePicker, returnDatePicker, actualReturnDatePicker;
    private CheckBox finePaidCheckbox;
    private Button checkAvailabilityButton, issueBookButton, returnBookButton, logOutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions2);

        bookNameInput = findViewById(R.id.editText_book_name);
        authorNameInput = findViewById(R.id.editText_author_name);
        serialNoInput = findViewById(R.id.editText_serial_no);
        fineCalculatedInput = findViewById(R.id.editText_fine_calculated);
        remarksInput = findViewById(R.id.editText_remarks);
        issueDatePicker = findViewById(R.id.datePicker_issue_date);
        returnDatePicker = findViewById(R.id.datePicker_return_date);
        actualReturnDatePicker = findViewById(R.id.datePicker_actual_return_date);
        finePaidCheckbox = findViewById(R.id.checkbox_fine_paid);

        checkAvailabilityButton = findViewById(R.id.button_check_availability);
        issueBookButton = findViewById(R.id.button_issue_book);
        returnBookButton = findViewById(R.id.button_return_book);
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

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOut();
            }

            private void logOut() {

            }
        });
    }
    private void checkBookAvailability() {
        String bookName = bookNameInput.getText().toString();
        if (bookName.isEmpty()) {
            Toast.makeText(this, "Enter book name to check availability", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Checking availability for: " + bookName, Toast.LENGTH_SHORT).show();
        }
    }
    private void issueBook() {
        String bookName = bookNameInput.getText().toString();
        if (bookName.isEmpty()) {
            Toast.makeText(this, "Enter book name to issue", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Book issued: " + bookName, Toast.LENGTH_SHORT).show();
    }
    private void returnBook() {
        String authorName = authorNameInput.getText().toString();
        if (authorName.isEmpty()) {
            Toast.makeText(this, "Enter author name to return", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Book returned by: " + authorName, Toast.LENGTH_SHORT).show();

    }
}