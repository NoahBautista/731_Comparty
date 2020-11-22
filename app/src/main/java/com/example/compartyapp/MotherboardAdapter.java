package com.example.compartyapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MotherboardAdapter extends RecyclerView.Adapter<com.example.compartyapp.MotherboardAdapter.MotherboardHolder>
{
    private Context motherboardContext;
    private List<Motherboard> motherboards = new ArrayList<>();

    public MotherboardAdapter(Context motherboardContext)
    {
        this.motherboardContext = motherboardContext;
    }

    @NonNull
    @Override
    public MotherboardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.component_item,parent,false);
        return new MotherboardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MotherboardHolder holder, int position) {
        Component currentComponent = motherboards.get(position);
        holder.textViewName.setText(currentComponent.getName());
        holder.textViewManufacturer.setText(currentComponent.getManufacturer());
        holder.textViewPrice.setText(String.valueOf(currentComponent.getPrice()));
        holder.textViewProductType.setText(currentComponent.getProductType());
        holder.imageView.setImageResource(currentComponent.getImage());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(motherboardContext,ViewMotherboard.class);
                intent.putExtra("Image",motherboards.get(holder.getAdapterPosition()).getImage());
                intent.putExtra("Description",motherboards.get(holder.getAdapterPosition()).getDescription());
                intent.putExtra("Link",motherboards.get(holder.getAdapterPosition()).getLink());
                intent.putExtra("Size",motherboards.get(holder.getAdapterPosition()).getSize());
                intent.putExtra("Socket",motherboards.get(holder.getAdapterPosition()).getSocket());
                intent.putExtra("RamSupport",motherboards.get(holder.getAdapterPosition()).getRamSupport());
                intent.putExtra("PCIESupport",motherboards.get(holder.getAdapterPosition()).getPcieSupport());
                motherboardContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return motherboards.size();
    }

    public void setComponents(List<Motherboard> motherboards)
    {
        this.motherboards = motherboards;
        notifyDataSetChanged();
    }

    public Motherboard getMotherboardAt(int position)
    {
        return motherboards.get(position);
    }

    class MotherboardHolder extends RecyclerView.ViewHolder
    {
        private TextView textViewName;
        private TextView textViewManufacturer;
        private TextView textViewPrice;
        private TextView textViewProductType;
        private ImageView imageView;
        private CardView cardView;

        public MotherboardHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_title);
            textViewManufacturer = itemView.findViewById(R.id.text_view_manufacturer);
            textViewPrice = itemView.findViewById(R.id.text_view_price);
            textViewProductType = itemView.findViewById(R.id.text_view_productType);
            imageView = itemView.findViewById(R.id.imageViewImage);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }

}
