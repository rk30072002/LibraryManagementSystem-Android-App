package com.example.librarymanagmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ReturnBookTr extends AppCompatActivity {
    private EditText etBookName, etAuthor, etIssueDate, etReturnDate, etRemarks;
    private Button btnCheckAvailability, btnReturnBook, btnIssueBook, btnPayFine, btnHome, btnLogout;
    private Spinner spinnerSerialNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_book_tr);

        etBookName = findViewById(R.id.et_book_name);
        etAuthor = findViewById(R.id.et_author);
        etIssueDate = findViewById(R.id.et_issue_date);
        etReturnDate = findViewById(R.id.et_return_date);
        etRemarks = findViewById(R.id.et_remarks);
        btnCheckAvailability = findViewById(R.id.btn_check_availability);
        btnReturnBook = findViewById(R.id.btn_return_book);
        btnIssueBook = findViewById(R.id.btn_issue_book);
        btnPayFine = findViewById(R.id.btn_pay_fine);
        btnHome = findViewById(R.id.btn_home);
        spinnerSerialNo = findViewById(R.id.spinner_serial_no);
        btnLogout = findViewById(R.id.btn_logout);

        btnCheckAvailability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBookAvailability();
            }
        });

        btnReturnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnBook();
            }
        });

        btnIssueBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                issueBook();
            }
        });

        btnPayFine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payFine();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToHome();
            }

            private void navigateToHome() {

            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }

            private void logout() {
            }
        });
    }

    private void checkBookAvailability() {
        String bookName = etBookName.getText().toString().trim();
        Toast.makeText(this, "Checked availability for: " + bookName, Toast.LENGTH_SHORT).show();
    }

    private void returnBook() {
        String author = etAuthor.getText().toString().trim();
        Toast.makeText(this, "Returned book by: " + author, Toast.LENGTH_SHORT).show();
    }

    private void issueBook() {
        String bookName = etBookName.getText().toString().trim();
        Toast.makeText(this, "Issued book: " + bookName, Toast.LENGTH_SHORT).show();
    }

    private void payFine() {
        String serialNo = spinnerSerialNo.getSelectedItem().toString();
        Toast.makeText(this, "Paid fine for: " + serialNo, Toast.LENGTH_SHORT).show();
    }

}
