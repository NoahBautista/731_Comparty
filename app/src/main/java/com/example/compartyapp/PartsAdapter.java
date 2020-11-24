package com.example.compartyapp;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class PartsAdapter extends FirestoreRecyclerAdapter <Parts, PartsAdapter.PartsHolder>{

    private Context partsContext;
    public PartsAdapter(@NonNull FirestoreRecyclerOptions<Parts> options, Context partsContext) {
        super(options);
        this.partsContext = partsContext;
    }

    @Override
    protected void onBindViewHolder(@NonNull PartsHolder holder, int position, @NonNull Parts model) {
        holder.tvName.setText(model.getName());
        holder.tvManu.setText(model.getManufacturer());
        holder.tvPrice.setText(String.valueOf(model.getPrice()));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(partsContext, PartsView.class);
//                intent.putExtra("Image",cpus.get(holder.getAdapterPosition()).getImage());
//                intent.putExtra("Description",cpus.get(holder.getAdapterPosition()).getDescription());
//                intent.putExtra("BoostClock",cpus.get(holder.getAdapterPosition()).getLink());
//                intent.putExtra("NumberOfCores",cpus.get(holder.getAdapterPosition()).getNumberOfCores());
//                intent.putExtra("NumberOfThreads",cpus.get(holder.getAdapterPosition()).getNumberOfThreads());
//                intent.putExtra("BaseClock",cpus.get(holder.getAdapterPosition()).getBaseClock());
//                intent.putExtra("BoostClock",cpus.get(holder.getAdapterPosition()).getBoostClock());
//                intent.putExtra("Link",cpus.get(holder.getAdapterPosition()).getLink());
//                intent.putExtra("Name",cpus.get(holder.getAdapterPosition()).getName());

                intent.putExtra("NameP", model.getName());
                intent.putExtra("Description", model.getDescription());
                intent.putExtra("Manufacturer", model.getManufacturer());
                intent.putExtra("Price", model.getPrice());
                intent.putExtra("Link", model.getLink());
                //intent.putExtra("ProductType", model.getType());

                partsContext.startActivity(intent);
            }
        });



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
        private CardView cardView;

        public PartsHolder (View itemView){
            super(itemView);
            tvName = itemView.findViewById(R.id.text_view_title);
            tvManu = itemView.findViewById(R.id.text_view_manufacturer);
            tvPrice = itemView.findViewById(R.id.text_view_price);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
