package com.example.librarymanagmentsystem;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OverdueReturnAdapter extends RecyclerView.Adapter {
    public OverdueReturnAdapter(MasterListActivity masterListActivity, ArrayList<OverdueReturn> overdueReturnList) {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void notifyDataSetChanged() {
    }
}
