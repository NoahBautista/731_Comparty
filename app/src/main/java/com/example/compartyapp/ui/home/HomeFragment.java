package com.example.compartyapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.compartyapp.CPUView;
import com.example.compartyapp.CasesView;
import com.example.compartyapp.GPUView;
import com.example.compartyapp.MotherboardView;
import com.example.compartyapp.PowerSupplyView;
import com.example.compartyapp.R;
import com.example.compartyapp.RamView;
import com.example.compartyapp.ui.slideshow.SlideshowFragment;
import com.example.compartyapp.ui.slideshow.SlideshowViewModel;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        Button processor = root.findViewById(R.id.btn_cpu);
        processor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Fragment someFragment = new SlideshowFragment();
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.add(R.id.fragmentSlideshow,someFragment);
//                transaction.replace(R.id.fragmentSlideshow, someFragment);
//                transaction.addToBackStack(null);
//                transaction.commit();

                Intent intent = new Intent(getActivity(), CPUView.class);
                view.getContext().startActivity(intent);
            }
        });

        Button graphics_card  = root.findViewById(R.id.btn_gpu);
        graphics_card .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GPUView.class);
                view.getContext().startActivity(intent);}
        });

        Button ram = root.findViewById(R.id.btn_ram);
        ram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RamView.class);
                view.getContext().startActivity(intent);}
        });

        Button motherboard = root.findViewById(R.id.btn_mobo);
        motherboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MotherboardView.class);
                view.getContext().startActivity(intent);}
        });

        Button cases = root.findViewById(R.id.btn_case);
        cases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CasesView.class);
                view.getContext().startActivity(intent);}
        });
        Button powerSupply = root.findViewById(R.id.btn_power);
        powerSupply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PowerSupplyView.class);
                view.getContext().startActivity(intent);}
        });


        return root;
    }
}