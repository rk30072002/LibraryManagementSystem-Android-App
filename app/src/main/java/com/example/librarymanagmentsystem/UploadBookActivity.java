package com.example.librarymanagmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UploadBookActivity extends AppCompatActivity {

    EditText bookTitle, authorName, sellingPrice;
    Button uploadBookBtn;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_book);

        databaseReference = FirebaseDatabase.getInstance().getReference("LibraryManagementSystem").child("Books");


        bookTitle = findViewById(R.id.bookTitle);
        authorName = findViewById(R.id.authorName);
        sellingPrice = findViewById(R.id.sellingPrice);

        uploadBookBtn = findViewById(R.id.uploadBookBtn);

        uploadBookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String BTitle = bookTitle.getText().toString();
                String authName = authorName.getText().toString();
                String sellPrice = sellingPrice.getText().toString();

                String bookId = databaseReference.push().getKey();

                Book book = new Book(bookId, BTitle, authName, sellPrice);

                databaseReference.child(bookId).setValue(book)
                        .addOnCompleteListener(task -> {
                            if(task.isSuccessful()){
                                Toast.makeText(UploadBookActivity.this, "Book Upload Successfully", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(UploadBookActivity.this, "Failed to upload Book", Toast.LENGTH_SHORT).show();
                            }
                        });


            }
        });

    }
}