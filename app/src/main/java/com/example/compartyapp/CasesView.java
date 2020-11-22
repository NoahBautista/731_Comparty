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

public class CasesView extends AppCompatActivity {

    public static final int ADD_CASES_REQUEST = 1;
    private ComponentViewModel componentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases_view);

        FloatingActionButton buttonAddCases = findViewById(R.id.button_add_cases);
        buttonAddCases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.compartyapp.CasesView.this, AddCases.class);
                startActivityForResult(intent, ADD_CASES_REQUEST);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        com.example.compartyapp.CasesAdapter adapter = new com.example.compartyapp.CasesAdapter(com.example.compartyapp.CasesView.this);
        recyclerView.setAdapter(adapter);

        componentViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(ComponentViewModel.class);
        componentViewModel.getAllCases().observe(this, new Observer<List<Cases>>() {
            @Override
            public void onChanged(@Nullable List<Cases> cases) {
                adapter.setComponents(cases);
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
                componentViewModel.deleteCases(adapter.getCasesAt(viewHolder.getAdapterPosition()));
                Toast.makeText(com.example.compartyapp.CasesView.this, "Cases deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ADD_CASES_REQUEST && resultCode == RESULT_OK)
        {
            String name = data.getStringExtra(AddCases.EXTRA_NAME);
            String description = data.getStringExtra(AddCases.EXTRA_DESCRIPTION);
            String manufacturer = data.getStringExtra(AddCases.EXTRA_MANUFACTURER);
            String link = data.getStringExtra(AddCases.EXTRA_LINK);
            double price = data.getDoubleExtra(AddCases.EXTRA_PRICE, 0.00);
            String productType = data.getStringExtra(AddCases.EXTRA_TYPE);
            String sizeSupport = data.getStringExtra(AddCases.EXTRA_SIZESUP);


            Cases cases = new Cases(R.drawable.componentdefault,name,description,manufacturer,link,price,productType,sizeSupport);
            componentViewModel.insertCases(cases);
            Toast.makeText(this, "Case saved", Toast.LENGTH_SHORT).show();
        } else
        {
            Toast.makeText(this, "Case not saved", Toast.LENGTH_SHORT).show();
        }
    }

}