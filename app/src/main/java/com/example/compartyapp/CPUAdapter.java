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

import com.example.compartyapp.ui.slideshow.SlideshowFragment;

import java.util.ArrayList;
import java.util.List;

public class CPUAdapter extends RecyclerView.Adapter<com.example.compartyapp.CPUAdapter.CPUHolder>
{
    private Context cpuContext;
    private List<CPU> cpus = new ArrayList<>();

    public CPUAdapter(Context cpuContext)
    {
        this.cpuContext = cpuContext;
    }

    @NonNull
    @Override
    public CPUHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.component_item,parent,false);
        return new CPUHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CPUHolder holder, int position) {
        Component currentComponent = cpus.get(position);
        holder.textViewName.setText(currentComponent.getName());
        holder.textViewManufacturer.setText(currentComponent.getManufacturer());
        holder.textViewPrice.setText(String.valueOf(currentComponent.getPrice()));
        holder.textViewProductType.setText(currentComponent.getProductType());
        holder.imageView.setImageResource(currentComponent.getImage());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cpuContext, ViewCPU.class);
                intent.putExtra("Image",cpus.get(holder.getAdapterPosition()).getImage());
                intent.putExtra("Description",cpus.get(holder.getAdapterPosition()).getDescription());
                intent.putExtra("BoostClock",cpus.get(holder.getAdapterPosition()).getLink());
                intent.putExtra("NumberOfCores",cpus.get(holder.getAdapterPosition()).getNumberOfCores());
                intent.putExtra("NumberOfThreads",cpus.get(holder.getAdapterPosition()).getNumberOfThreads());
                intent.putExtra("BaseClock",cpus.get(holder.getAdapterPosition()).getBaseClock());
                intent.putExtra("BoostClock",cpus.get(holder.getAdapterPosition()).getBoostClock());
                intent.putExtra("Link",cpus.get(holder.getAdapterPosition()).getLink());
                intent.putExtra("Name",cpus.get(holder.getAdapterPosition()).getName());
                cpuContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cpus.size();
    }

    public void setComponents(List<CPU> cpus)
    {
        this.cpus = cpus;
        notifyDataSetChanged();
    }

    public CPU getCPUAt(int position)
    {
        return cpus.get(position);
    }

    class CPUHolder extends RecyclerView.ViewHolder
    {
        private TextView textViewName;
        private TextView textViewManufacturer;
        private TextView textViewPrice;
        private TextView textViewProductType;
        private ImageView imageView;
        private CardView cardView;

        public CPUHolder(@NonNull View itemView) {
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
