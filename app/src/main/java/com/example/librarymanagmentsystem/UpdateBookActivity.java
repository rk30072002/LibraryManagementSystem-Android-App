package com.example.librarymanagmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateBookActivity extends AppCompatActivity {

    EditText bookTitle1, authorName1, sellingPrice1;

    Button updateBookBtn1;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_book);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("");

        bookTitle1 = findViewById(R.id.bookTitle1);
        authorName1 = findViewById(R.id.authorName1);
        sellingPrice1 = findViewById(R.id.sellingPrice1);

        updateBookBtn1 = findViewById(R.id.updateBookBtn1);

        updateBookBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}