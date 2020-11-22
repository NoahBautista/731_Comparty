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

public class CPUView extends AppCompatActivity {

    public static final int ADD_CPU_REQUEST = 1;

    private ComponentViewModel componentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processor_view);

        FloatingActionButton buttonAddCPU = findViewById(R.id.button_add_cpu);
        buttonAddCPU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.compartyapp.CPUView.this, AddCPU.class);
                startActivityForResult(intent, ADD_CPU_REQUEST);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        CPUAdapter adapter = new CPUAdapter(com.example.compartyapp.CPUView.this);
        recyclerView.setAdapter(adapter);

        componentViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(ComponentViewModel.class);
        componentViewModel.getAllCPUs().observe(this, new Observer<List<CPU>>() {
            @Override
            public void onChanged(@Nullable List<CPU> cpus) {
                adapter.setComponents(cpus);
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
                componentViewModel.deleteCPU(adapter.getCPUAt(viewHolder.getAdapterPosition()));
                Toast.makeText(com.example.compartyapp.CPUView.this, "CPU deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ADD_CPU_REQUEST && resultCode == RESULT_OK)
        {
            String name = data.getStringExtra(AddCPU.EXTRA_NAME);
            String description = data.getStringExtra(AddCPU.EXTRA_DESCRIPTION);
            String manufacturer = data.getStringExtra(AddCPU.EXTRA_MANUFACTURER);
            String link = data.getStringExtra(AddCPU.EXTRA_LINK);
            double price = data.getDoubleExtra(AddCPU.EXTRA_PRICE, 0.00);
            String productType = data.getStringExtra(AddCPU.EXTRA_TYPE);
            int numberOfCores = data.getIntExtra(AddCPU.EXTRA_NUMBERCORES, 0);
            int numberOfThreads = data.getIntExtra(AddCPU.EXTRA_NUMBERTHREADS, 0);
            String baseClock = data.getStringExtra(AddCPU.EXTRA_BASEC);
            String boostClock = data.getStringExtra(AddCPU.EXTRA_BOOSTC);

            CPU cpu = new CPU(R.drawable.componentdefault,name,description,manufacturer,link,price,productType,numberOfCores,numberOfThreads,baseClock,boostClock);
            componentViewModel.insertCPU(cpu);
            Toast.makeText(this, "CPU saved", Toast.LENGTH_SHORT).show();
        } else
        {
            Toast.makeText(this, "CPU not saved", Toast.LENGTH_SHORT).show();
        }
    }
}