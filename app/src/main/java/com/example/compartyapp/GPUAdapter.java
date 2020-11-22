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

public class GPUAdapter extends RecyclerView.Adapter<com.example.compartyapp.GPUAdapter.GPUHolder>
{
    private Context gpuContext;
    private List<GPU> gpus = new ArrayList<>();

    public GPUAdapter(Context gpuContext)
    {
        this.gpuContext = gpuContext;
    }

    @NonNull
    @Override
    public GPUHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.component_item,parent,false);
        return new GPUHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GPUHolder holder, int position) {
        Component currentComponent = gpus.get(position);
        holder.textViewName.setText(currentComponent.getName());
        holder.textViewManufacturer.setText(currentComponent.getManufacturer());
        holder.textViewPrice.setText(String.valueOf(currentComponent.getPrice()));
        holder.textViewProductType.setText(currentComponent.getProductType());
        holder.imageView.setImageResource(currentComponent.getImage());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gpuContext,ViewGPU.class);
                intent.putExtra("Image",gpus.get(holder.getAdapterPosition()).getImage());
                intent.putExtra("Description",gpus.get(holder.getAdapterPosition()).getDescription());
                intent.putExtra("Link",gpus.get(holder.getAdapterPosition()).getLink());
                intent.putExtra("Cores",gpus.get(holder.getAdapterPosition()).getCores());
                intent.putExtra("VRAM",gpus.get(holder.getAdapterPosition()).getVram());
                intent.putExtra("GPUBaseClock",gpus.get(holder.getAdapterPosition()).getGpuBaseClock());
                intent.putExtra("GPUBoostClock",gpus.get(holder.getAdapterPosition()).getGpuBoostClock());
                intent.putExtra("PCIEVersion",gpus.get(holder.getAdapterPosition()).getPcieVersion());
                gpuContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gpus.size();
    }

    public void setComponents(List<GPU> gpus)
    {
        this.gpus = gpus;
        notifyDataSetChanged();
    }

    public GPU getGPUAt(int position)
    {
        return gpus.get(position);
    }

    class GPUHolder extends RecyclerView.ViewHolder
    {
        private TextView textViewName;
        private TextView textViewManufacturer;
        private TextView textViewPrice;
        private TextView textViewProductType;
        private ImageView imageView;
        private CardView cardView;

        public GPUHolder(@NonNull View itemView) {
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