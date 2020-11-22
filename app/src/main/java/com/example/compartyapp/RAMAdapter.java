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

public class RAMAdapter extends RecyclerView.Adapter<com.example.compartyapp.RAMAdapter.RAMHolder>
{
    private Context ramContext;
    private List<RAM> rams = new ArrayList<>();


    public RAMAdapter(Context ramContext)
    {
        this.ramContext = ramContext;
    }

    @NonNull
    @Override
    public RAMHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.component_item,parent,false);
        return new RAMHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RAMHolder holder, int position) {
        Component currentComponent = rams.get(position);
        holder.textViewName.setText(currentComponent.getName());
        holder.textViewManufacturer.setText(currentComponent.getManufacturer());
        holder.textViewPrice.setText(String.valueOf(currentComponent.getPrice()));
        holder.textViewProductType.setText(currentComponent.getProductType());
        holder.imageView.setImageResource(currentComponent.getImage());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ramContext,ViewRAM.class);
                intent.putExtra("Image",rams.get(holder.getAdapterPosition()).getImage());
                intent.putExtra("Description",rams.get(holder.getAdapterPosition()).getDescription());
                intent.putExtra("Link",rams.get(holder.getAdapterPosition()).getLink());
                intent.putExtra("Frequency",rams.get(holder.getAdapterPosition()).getFrequency());
                intent.putExtra("MemoryType",rams.get(holder.getAdapterPosition()).getMemoryType());
                intent.putExtra("Capacity",rams.get(holder.getAdapterPosition()).getCapacity());
                intent.putExtra("NumberOfSticks",rams.get(holder.getAdapterPosition()).getNumberOfSticks());
                ramContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rams.size();
    }

    public void setComponents(List<RAM> rams)
    {
        this.rams = rams;
        notifyDataSetChanged();
    }

    public RAM getRAMAt(int position)
    {
        return rams.get(position);
    }

    class RAMHolder extends RecyclerView.ViewHolder
    {
        private TextView textViewName;
        private TextView textViewManufacturer;
        private TextView textViewPrice;
        private TextView textViewProductType;
        private ImageView imageView;
        private CardView cardView;

        public RAMHolder(@NonNull View itemView) {
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
