package com.example.librarymanagmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminActivity extends AppCompatActivity {
    MaterialCardView addBook, updateBook, manageMembership, delete;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("LibraryManagementSystem");


        addBook = findViewById(R.id.addBook);
        updateBook = findViewById(R.id.updateBook);
        manageMembership = findViewById(R.id.manageMembership);
        delete = findViewById(R.id.delete);

        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, UploadBookActivity.class);
                startActivity(intent);
            }
        });
        updateBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, UpdateBookActivity.class);
                startActivity(intent);
            }
        });
        manageMembership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, membershipActivity.class);
                startActivity(intent);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, deleteActivity.class);
                startActivity(intent);
            }
        });

    }


    private void addEbookToFirebase(){
        String ebookId = databaseReference.push().getKey();
        Ebook ebook = new Ebook(ebookId,"ebook Title", "Author Name");

        databaseReference.child("eBooks").child(ebookId).setValue(ebook)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(AdminActivity.this, "eBook Added Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(AdminActivity.this, "Failed to Add eBook", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}