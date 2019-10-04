package com.example.myrepos.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myrepos.R;
import com.example.myrepos.data.ReposDTO;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<ReposDTO> list;

    public RecycleAdapter(List<ReposDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ReposDTO reposDTO = list.get(position);
        holder.name.setText(reposDTO.getmName());
        holder.description.setText(reposDTO.getmDescription());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
