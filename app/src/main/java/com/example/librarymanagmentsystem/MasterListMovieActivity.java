package com.example.librarymanagmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MasterListMovieActivity extends AppCompatActivity {
    private Button masterListBooksButton, masterListMoviesButton, logOutButton;
    private TableLayout tableLayout;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_list_movie);

        masterListBooksButton = findViewById(R.id.masterListBooksButton);
        masterListMoviesButton = findViewById(R.id.masterListMoviesButton);
        logOutButton = findViewById(R.id.logOutButton);
        tableLayout = findViewById(R.id.tableLayout);

        databaseReference = FirebaseDatabase.getInstance().getReference("books");


        loadMasterListOfBooks();
        masterListBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMasterListOfBooks();
            }
        });

        masterListMoviesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MasterListMovieActivity.this, MasterListMovieActivity.class));
            }
        });

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MasterListMovieActivity.this, LoginActivity.class));
                finish(); 
            }
        });
    }

    private void loadMasterListOfBooks() {
        if (tableLayout.getChildCount() > 1) {
            tableLayout.removeViews(1, tableLayout.getChildCount() - 1);
        }
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot bookSnapshot : dataSnapshot.getChildren()) {
                    String serialNo = bookSnapshot.child("serialNo").getValue(String.class);
                    String name = bookSnapshot.child("name").getValue(String.class);
                    String author = bookSnapshot.child("author").getValue(String.class);
                    String category = bookSnapshot.child("category").getValue(String.class);
                    String status = bookSnapshot.child("status").getValue(String.class);
                    String cost = bookSnapshot.child("cost").getValue(String.class);
                    TableLayout tableRow = new TableLayout(MasterListMovieActivity.this);

                    TextView serialNoText = new TextView(MasterListMovieActivity.this);
                    serialNoText.setText(serialNo);
                    tableRow.addView(serialNoText);

                    TextView nameText = new TextView(MasterListMovieActivity.this);
                    nameText.setText(name);
                    tableRow.addView(nameText);

                    TextView authorText = new TextView(MasterListMovieActivity.this);
                    authorText.setText(author);
                    tableRow.addView(authorText);

                    TextView categoryText = new TextView(MasterListMovieActivity.this);
                    categoryText.setText(category);
                    tableRow.addView(categoryText);

                    TextView statusText = new TextView(MasterListMovieActivity.this);
                    statusText.setText(status);
                    tableRow.addView(statusText);

                    TextView costText = new TextView(MasterListMovieActivity.this);
                    costText.setText(cost);
                    tableRow.addView(costText);

                    TextView procurementDateText = new TextView(MasterListMovieActivity.this);
                    int procurementDate = 0;
                    procurementDateText.setText(procurementDate);
                    tableRow.addView(procurementDateText);

                    tableLayout.addView(tableLayout);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                String errorMessage = databaseError.getMessage();
                System.out.println("Database Error: " + errorMessage);
                Toast.makeText(MasterListMovieActivity.this, "Error fetching data: " + errorMessage, Toast.LENGTH_LONG).show();
                switch (databaseError.getCode()) {
                    case DatabaseError.PERMISSION_DENIED:
                        Toast.makeText(MasterListMovieActivity.this, "Permission denied", Toast.LENGTH_LONG).show();
                        break;
                    case DatabaseError.DISCONNECTED:

                        Toast.makeText(MasterListMovieActivity.this, "Network disconnected.", Toast.LENGTH_LONG).show();
                        break;
                    default:

                        Toast.makeText(MasterListMovieActivity.this, "Please try again.", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }
}