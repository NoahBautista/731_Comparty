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

public class RamView extends AppCompatActivity {

    public static final int ADD_RAM_REQUEST = 1;
    private ComponentViewModel componentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ram_view);

        FloatingActionButton buttonAddGPU = findViewById(R.id.button_add_ram);
        buttonAddGPU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.compartyapp.RamView.this, AddRAM.class);
                startActivityForResult(intent, ADD_RAM_REQUEST);
            }
        });


        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        RAMAdapter adapter = new RAMAdapter(com.example.compartyapp.RamView.this);
        recyclerView.setAdapter(adapter);

        componentViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(ComponentViewModel.class);
        componentViewModel.getAllRAMs().observe(this, new Observer<List<RAM>>() {
            @Override
            public void onChanged(@Nullable List<RAM> rams) {
                adapter.setComponents(rams);
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
                componentViewModel.deleteRAM(adapter.getRAMAt(viewHolder.getAdapterPosition()));
                Toast.makeText(com.example.compartyapp.RamView.this, "RAM deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ADD_RAM_REQUEST && resultCode == RESULT_OK)
        {
            String name = data.getStringExtra(AddRAM.EXTRA_NAME);
            String description = data.getStringExtra(AddRAM.EXTRA_DESCRIPTION);
            String manufacturer = data.getStringExtra(AddRAM.EXTRA_MANUFACTURER);
            String link = data.getStringExtra(AddRAM.EXTRA_LINK);
            double price = data.getDoubleExtra(AddRAM.EXTRA_PRICE, 0.00);
            String productType = data.getStringExtra(AddRAM.EXTRA_TYPE);
            String frequency = data.getStringExtra(AddRAM.EXTRA_FREQUENCY);
            String memoryType = data.getStringExtra(AddRAM.EXTRA_MTYPE);
            String capacity = data.getStringExtra(AddRAM.EXTRA_CAPACITY);
            int numnberSticks = data.getIntExtra(AddRAM.EXTRA_NUMBERSTICKS, 0);


            RAM ram = new RAM(R.drawable.componentdefault,name,description,manufacturer,link,price,productType,frequency,memoryType,capacity,numnberSticks);
            componentViewModel.insertRAM(ram);
            Toast.makeText(this, "RAM saved", Toast.LENGTH_SHORT).show();
        } else
        {
            Toast.makeText(this, "RAM not saved", Toast.LENGTH_SHORT).show();
        }
    }
}