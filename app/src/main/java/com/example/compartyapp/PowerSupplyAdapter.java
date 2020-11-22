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

public class PowerSupplyAdapter extends RecyclerView.Adapter<com.example.compartyapp.PowerSupplyAdapter.PowerSupplyHolder>
{
    private List<PowerSupply> powerSupplies = new ArrayList<>();
    private Context powerSupplyContext;

    public PowerSupplyAdapter(Context powerSupplyContext)
    {
        this.powerSupplyContext = powerSupplyContext;
    }

    @NonNull
    @Override
    public PowerSupplyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.component_item,parent,false);
        return new PowerSupplyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PowerSupplyHolder holder, int position) {
        Component currentComponent = powerSupplies.get(position);
        holder.textViewName.setText(currentComponent.getName());
        holder.textViewManufacturer.setText(currentComponent.getManufacturer());
        holder.textViewPrice.setText(String.valueOf(currentComponent.getPrice()));
        holder.textViewProductType.setText(currentComponent.getProductType());
        holder.imageView.setImageResource(currentComponent.getImage());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(powerSupplyContext,ViewPowerSupply.class);
                intent.putExtra("Image",powerSupplies.get(holder.getAdapterPosition()).getImage());
                intent.putExtra("Description",powerSupplies.get(holder.getAdapterPosition()).getDescription());
                intent.putExtra("Link",powerSupplies.get(holder.getAdapterPosition()).getLink());
                intent.putExtra("PType",powerSupplies.get(holder.getAdapterPosition()).getType());
                intent.putExtra("PCapacity",powerSupplies.get(holder.getAdapterPosition()).getCapacity());
                intent.putExtra("Rating",powerSupplies.get(holder.getAdapterPosition()).getRating());
                powerSupplyContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return powerSupplies.size();
    }

    public void setComponents(List<PowerSupply> powerSupplies)
    {
        this.powerSupplies = powerSupplies;
        notifyDataSetChanged();
    }

    public PowerSupply getPowerSupplyAt(int position)
    {
        return powerSupplies.get(position);
    }

    class PowerSupplyHolder extends RecyclerView.ViewHolder
    {
        private TextView textViewName;
        private TextView textViewManufacturer;
        private TextView textViewPrice;
        private TextView textViewProductType;
        private ImageView imageView;
        private CardView cardView;

        public PowerSupplyHolder(@NonNull View itemView) {
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