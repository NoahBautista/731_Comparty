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

public class GPUView extends AppCompatActivity {

    public static final int ADD_GPU_REQUEST = 1;

    private ComponentViewModel componentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphics_view);

        FloatingActionButton buttonAddGPU = findViewById(R.id.button_add_gpu);
        buttonAddGPU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.compartyapp.GPUView.this, AddGPU.class);
                startActivityForResult(intent, ADD_GPU_REQUEST);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        GPUAdapter adapter = new GPUAdapter(com.example.compartyapp.GPUView.this);
        recyclerView.setAdapter(adapter);

        componentViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(ComponentViewModel.class);
        componentViewModel.getAllGPUs().observe(this, new Observer<List<GPU>>() {
            @Override
            public void onChanged(@Nullable List<GPU> gpus) {
                adapter.setComponents(gpus);
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
                componentViewModel.deleteGPU(adapter.getGPUAt(viewHolder.getAdapterPosition()));
                Toast.makeText(com.example.compartyapp.GPUView.this, "GPU deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ADD_GPU_REQUEST && resultCode == RESULT_OK)
        {
            String name = data.getStringExtra(AddGPU.EXTRA_NAME);
            String description = data.getStringExtra(AddGPU.EXTRA_DESCRIPTION);
            String manufacturer = data.getStringExtra(AddGPU.EXTRA_MANUFACTURER);
            String link = data.getStringExtra(AddGPU.EXTRA_LINK);
            double price = data.getDoubleExtra(AddGPU.EXTRA_PRICE, 0.00);
            String productType = data.getStringExtra(AddGPU.EXTRA_TYPE);
            int cores = data.getIntExtra(AddGPU.EXTRA_NUMBERCORES, 0);
            int vram = data.getIntExtra(AddGPU.EXTRA_VRAM, 0);
            String gpuBaseClock = data.getStringExtra(AddGPU.EXTRA_BASEC);
            String gpuBoostClock = data.getStringExtra(AddGPU.EXTRA_BOOSTC);
            String pcieVersion = data.getStringExtra(AddGPU.EXTRA_PCIE);

            GPU gpu = new GPU(R.drawable.componentdefault,name,description,manufacturer,link,price,productType,cores,vram,gpuBaseClock,gpuBoostClock,pcieVersion);
            componentViewModel.insertGPU(gpu);
            Toast.makeText(this, "GPU saved", Toast.LENGTH_SHORT).show();
        } else
        {
            Toast.makeText(this, "GPU not saved", Toast.LENGTH_SHORT).show();
        }
    }


}