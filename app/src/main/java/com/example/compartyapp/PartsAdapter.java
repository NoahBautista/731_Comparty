package com.example.compartyapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class PartsAdapter extends FirestoreRecyclerAdapter <Parts, PartsAdapter.PartsHolder>{

    public PartsAdapter(@NonNull FirestoreRecyclerOptions<Parts> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PartsHolder holder, int position, @NonNull Parts model) {
        holder.tvName.setText(model.getName());
        holder.tvManu.setText(model.getManufacturer());
        holder.tvPrice.setText(String.valueOf(model.getPrice()));

    }

    @NonNull
    @Override
    public PartsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_item, parent, false);
        return new PartsHolder(v);
    }

    class PartsHolder  extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvManu;
        TextView tvPrice;
        TextView tvLink;
        TextView tvType;

        public PartsHolder (View itemView){
            super(itemView);
            tvName = itemView.findViewById(R.id.text_view_title);
            tvManu = itemView.findViewById(R.id.text_view_manufacturer);
            tvPrice = itemView.findViewById(R.id.text_view_price);
        }
    }
}
