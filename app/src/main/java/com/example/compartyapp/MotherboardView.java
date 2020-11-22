package com.example.compartyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MotherboardView extends AppCompatActivity {

    public static final int ADD_MOTHERBOARD_REQUEST = 1;
    private ComponentViewModel componentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motherboard_view);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        FloatingActionButton buttonAddMotherboard = findViewById(R.id.button_add_motherboard);
        buttonAddMotherboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.compartyapp.MotherboardView.this, AddMotherboard.class);
                startActivityForResult(intent, ADD_MOTHERBOARD_REQUEST);
            }
        });


        MotherboardAdapter adapter = new MotherboardAdapter(com.example.compartyapp.MotherboardView.this);
        recyclerView.setAdapter(adapter);

        componentViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(ComponentViewModel.class);
        componentViewModel.getAllMotherboards().observe(this, new Observer<List<Motherboard>>() {
            @Override
            public void onChanged(@Nullable List<Motherboard> motherboards) {
                adapter.setComponents(motherboards);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                componentViewModel.deleteMotherboard(adapter.getMotherboardAt(viewHolder.getAdapterPosition()));
                Toast.makeText(com.example.compartyapp.MotherboardView.this, "Motherboard deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ADD_MOTHERBOARD_REQUEST && resultCode == RESULT_OK)
        {
            String name = data.getStringExtra(AddMotherboard.EXTRA_NAME);
            String description = data.getStringExtra(AddMotherboard.EXTRA_DESCRIPTION);
            String manufacturer = data.getStringExtra(AddMotherboard.EXTRA_MANUFACTURER);
            String link = data.getStringExtra(AddMotherboard.EXTRA_LINK);
            double price = data.getDoubleExtra(AddMotherboard.EXTRA_PRICE, 0.00);
            String productType = data.getStringExtra(AddMotherboard.EXTRA_TYPE);
            String size = data.getStringExtra(AddMotherboard.EXTRA_SIZE);
            String socket = data.getStringExtra(AddMotherboard.EXTRA_SOCKET);
            String ramSupport = data.getStringExtra(AddMotherboard.EXTRA_RAMSUP);
            String pcieSupport = data.getStringExtra(AddMotherboard.EXTRA_PCIESUP);


            Motherboard motherboard = new Motherboard(R.drawable.componentdefault,name,description,manufacturer,link,price,productType,size,socket,ramSupport,pcieSupport);
            componentViewModel.insertMotherboard(motherboard);
            Toast.makeText(this, "Motherboard saved", Toast.LENGTH_SHORT).show();
        } else
        {
            Toast.makeText(this, "Motherboard not saved", Toast.LENGTH_SHORT).show();
        }
    }
}