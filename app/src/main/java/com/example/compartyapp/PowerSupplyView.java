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

public class PowerSupplyView extends AppCompatActivity {


    public static final int ADD_POWERSUPPLY_REQUEST = 1;
    private ComponentViewModel componentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_supply_view);

        FloatingActionButton buttonAddPowerSupply = findViewById(R.id.button_add_powerSupply);
        buttonAddPowerSupply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.compartyapp.PowerSupplyView.this, AddPowerSupply.class);
                startActivityForResult(intent, ADD_POWERSUPPLY_REQUEST);
            }
        });


        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        PowerSupplyAdapter adapter = new PowerSupplyAdapter(com.example.compartyapp.PowerSupplyView.this);
        recyclerView.setAdapter(adapter);

        componentViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(ComponentViewModel.class);
        componentViewModel.getAllPowerSupplies().observe(this, new Observer<List<PowerSupply>>() {
            @Override
            public void onChanged(@Nullable List<PowerSupply> powerSupplies) {
                adapter.setComponents(powerSupplies);
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
                componentViewModel.deletePowerSupply(adapter.getPowerSupplyAt(viewHolder.getAdapterPosition()));
                Toast.makeText(com.example.compartyapp.PowerSupplyView.this, "Power Supply deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ADD_POWERSUPPLY_REQUEST && resultCode == RESULT_OK)
        {
            String name = data.getStringExtra(AddPowerSupply.EXTRA_NAME);
            String description = data.getStringExtra(AddPowerSupply.EXTRA_DESCRIPTION);
            String manufacturer = data.getStringExtra(AddPowerSupply.EXTRA_MANUFACTURER);
            String link = data.getStringExtra(AddPowerSupply.EXTRA_LINK);
            double price = data.getDoubleExtra(AddPowerSupply.EXTRA_PRICE, 0.00);
            String productType = data.getStringExtra(AddPowerSupply.EXTRA_TYPE);
            String typePower = data.getStringExtra(AddPowerSupply.EXTRA_TYPEP);
            String capacity = data.getStringExtra(AddPowerSupply.EXTRA_CAPACITY);
            String rating = data.getStringExtra(AddPowerSupply.EXTRA_RATING);


            PowerSupply powerSupply = new PowerSupply(R.drawable.componentdefault,name,description,manufacturer,link,price,productType,typePower,capacity,rating);
            componentViewModel.insertPowerSupply(powerSupply);
            Toast.makeText(this, "Power Supply saved", Toast.LENGTH_SHORT).show();
        } else
        {
            Toast.makeText(this, "Power Supply not saved", Toast.LENGTH_SHORT).show();
        }
    }



}