package com.example.myrepos.ui;

import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.myrepos.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public TextView description;
    public AppCompatButton btnVerMais;

    public ViewHolder(View itemView) {
        super(itemView);
        this.name = itemView.findViewById(R.id.name);
        this.description = itemView.findViewById(R.id.description);
        this.btnVerMais = itemView.findViewById(R.id.btnVerMais);
    }
}
