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

public class CasesAdapter extends RecyclerView.Adapter<com.example.compartyapp.CasesAdapter.CasesHolder>
{
    private List<Cases> cases = new ArrayList<>();
    private Context casesContext;

    public CasesAdapter(Context casesContext)
    {
        this.casesContext = casesContext;
    }

    @NonNull
    @Override
    public CasesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.component_item,parent,false);
        return new CasesHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CasesHolder holder, int position) {
        Component currentComponent = cases.get(position);
        holder.textViewName.setText(currentComponent.getName());
        holder.textViewManufacturer.setText(currentComponent.getManufacturer());
        holder.textViewPrice.setText(String.valueOf(currentComponent.getPrice()));
        holder.textViewProductType.setText(currentComponent.getProductType());
        holder.imageView.setImageResource(currentComponent.getImage());


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(casesContext,ViewCases.class);
                intent.putExtra("Image",cases.get(holder.getAdapterPosition()).getImage());
                intent.putExtra("Description",cases.get(holder.getAdapterPosition()).getDescription());
                intent.putExtra("Link",cases.get(holder.getAdapterPosition()).getLink());
                intent.putExtra("SizeSupport",cases.get(holder.getAdapterPosition()).getSizeSupport());
                casesContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cases.size();
    }

    public void setComponents(List<Cases> cases)
    {
        this.cases = cases;
        notifyDataSetChanged();
    }

    public Cases getCasesAt(int position)
    {
        return cases.get(position);
    }

    class CasesHolder extends RecyclerView.ViewHolder
    {
        private TextView textViewName;
        private TextView textViewManufacturer;
        private TextView textViewPrice;
        private TextView textViewProductType;
        private ImageView imageView;
        private CardView cardView;

        public CasesHolder(@NonNull View itemView) {
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
