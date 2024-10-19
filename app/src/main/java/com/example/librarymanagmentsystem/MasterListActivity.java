package com.example.librarymanagmentsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MasterListActivity extends AppCompatActivity {

    private RecyclerView recyclerViewBooks, recyclerViewMovies, recyclerViewOverdueReturns;
    private DatabaseReference databaseReferenceBooks, databaseReferenceMovies, databaseReferenceOverdueReturns;
    private ArrayList<Book> bookList;
    private ArrayList<Movie> movieList;
    private ArrayList<OverdueReturn> overdueReturnList;
    private BookAdapter bookAdapter;
    private MovieAdapter movieAdapter;
    private OverdueReturnAdapter overdueReturnAdapter;
    private Button logOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_list);

        recyclerViewBooks = findViewById(R.id.recycler_view_books);
        recyclerViewMovies = findViewById(R.id.recycler_view_movies);
        recyclerViewOverdueReturns = findViewById(R.id.recycler_view_overdue_returns);
        logOutButton = findViewById(R.id.log_out_button);

        databaseReferenceBooks = FirebaseDatabase.getInstance().getReference("Books");
        databaseReferenceMovies = FirebaseDatabase.getInstance().getReference("Movies");
        databaseReferenceOverdueReturns = FirebaseDatabase.getInstance().getReference("OverdueReturns");

        recyclerViewBooks.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMovies.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewOverdueReturns.setLayoutManager(new LinearLayoutManager(this));


        bookList = new ArrayList<>();
        movieList = new ArrayList<>();
        overdueReturnList = new ArrayList<>();

        bookAdapter = new BookAdapter(this, bookList);
        movieAdapter = new MovieAdapter(this, movieList);
        overdueReturnAdapter = new OverdueReturnAdapter(this, overdueReturnList);

        recyclerViewBooks.setAdapter(bookAdapter);
        recyclerViewMovies.setAdapter(movieAdapter);
        recyclerViewOverdueReturns.setAdapter(overdueReturnAdapter);

        fetchBooksData();
        fetchMoviesData();
        fetchOverdueReturnsData();


        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MasterListActivity.this, "Logging out...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MasterListActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void fetchBooksData() {
        databaseReferenceBooks.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                bookList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Book book = dataSnapshot.getValue(Book.class);
                    bookList.add(book);
                }
                bookAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MasterListActivity.this, "Error fetching book data", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void fetchMoviesData() {
        databaseReferenceMovies.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                movieList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Movie movie = dataSnapshot.getValue(Movie.class);
                    movieList.add(movie);
                }
                movieAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MasterListActivity.this, "Error fetching movie data", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void fetchOverdueReturnsData() {
        databaseReferenceOverdueReturns.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                overdueReturnList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    OverdueReturn overdueReturn = dataSnapshot.getValue(OverdueReturn.class);
                    overdueReturnList.add(overdueReturn);
                }
                overdueReturnAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MasterListActivity.this, "Error fetching overdue return data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}