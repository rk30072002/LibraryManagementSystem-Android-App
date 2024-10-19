package com.example.librarymanagmentsystem;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CheckBookAvailabilityActivity extends AppCompatActivity {

    private DatabaseReference booksDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_book_availability);
        booksDatabaseReference = FirebaseDatabase.getInstance().getReference("Books");
        booksDatabaseReference.child("book_id_example").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    String bookName = dataSnapshot.child("name").getValue(String.class);
                    String status = dataSnapshot.child("status").getValue(String.class);
                    if ("available".equalsIgnoreCase(status)) {
                        Toast.makeText(CheckBookAvailabilityActivity.this, bookName + " is available.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(CheckBookAvailabilityActivity.this, bookName + " is not available.", Toast.LENGTH_SHORT).show();
                    }
                } else {

                    Toast.makeText(CheckBookAvailabilityActivity.this, "Book not found.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(CheckBookAvailabilityActivity.this, "Error fetching data.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
