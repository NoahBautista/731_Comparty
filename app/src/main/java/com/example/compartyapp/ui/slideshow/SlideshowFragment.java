package com.example.compartyapp.ui.slideshow;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.compartyapp.AddCPU;
import com.example.compartyapp.CPU;
import com.example.compartyapp.CPUAdapter;
import com.example.compartyapp.ComponentViewModel;
import com.example.compartyapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class SlideshowFragment extends Fragment {

    private ComponentViewModel componentViewModel;
    public static final int ADD_CPU_REQUEST = 1;
    private Application mApplication;

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);


//        FloatingActionButton buttonAddCPU = root.findViewById(R.id.button_add_cpu);
//        buttonAddCPU.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), AddCPU.class);
//                startActivityForResult(intent, ADD_CPU_REQUEST);
//            }
//        });
//
//        RecyclerView recyclerView = root.findViewById(R.id.recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setHasFixedSize(true);
//
//        CPUAdapter adapter = new CPUAdapter(getContext());
//        recyclerView.setAdapter(adapter);
//
//        componentViewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(ComponentViewModel.class);
//        componentViewModel.getAllCPUs().observe(getViewLifecycleOwner(), new Observer<List<CPU>>() {
//            @Override
//            public void onChanged(@Nullable List<CPU> cpus) {
//                adapter.setComponents(cpus);
//            }
//        });
//
//        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
//                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
//            @Override
//            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
//                return false;
//            }
//
//            @Override
//            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//                componentViewModel.deleteCPU(adapter.getCPUAt(viewHolder.getAdapterPosition()));
//                Toast.makeText(getContext(), "CPU deleted", Toast.LENGTH_SHORT).show();
//            }
//        }).attachToRecyclerView(recyclerView);
        return root;
    }

//    private Application getApplication() {
//        return mApplication;
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == ADD_CPU_REQUEST && resultCode == -1)
//        {
//            String name = data.getStringExtra(AddCPU.EXTRA_NAME);
//            String description = data.getStringExtra(AddCPU.EXTRA_DESCRIPTION);
//            String manufacturer = data.getStringExtra(AddCPU.EXTRA_MANUFACTURER);
//            String link = data.getStringExtra(AddCPU.EXTRA_LINK);
//            double price = data.getDoubleExtra(AddCPU.EXTRA_PRICE, 0.00);
//            String productType = data.getStringExtra(AddCPU.EXTRA_TYPE);
//            int numberOfCores = data.getIntExtra(AddCPU.EXTRA_NUMBERCORES, 0);
//            int numberOfThreads = data.getIntExtra(AddCPU.EXTRA_NUMBERTHREADS, 0);
//            String baseClock = data.getStringExtra(AddCPU.EXTRA_BASEC);
//            String boostClock = data.getStringExtra(AddCPU.EXTRA_BOOSTC);
//
//            CPU cpu = new CPU(R.drawable.componentdefault,name,description,manufacturer,link,price,productType,numberOfCores,numberOfThreads,baseClock,boostClock);
//            componentViewModel.insertCPU(cpu);
//            Toast.makeText(getContext(), "CPU saved", Toast.LENGTH_SHORT).show();
//        } else
//        {
//            Toast.makeText(getContext(), "CPU not saved", Toast.LENGTH_SHORT).show();
//        }
//    }

    }
