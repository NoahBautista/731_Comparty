package com.example.compartyapp.ui.slideshow;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.compartyapp.AddCPU;
import com.example.compartyapp.CPU;
import com.example.compartyapp.CPUAdapter;
import com.example.compartyapp.Component;
import com.example.compartyapp.ComponentViewModel;
import com.example.compartyapp.Components;
import com.example.compartyapp.Parts;
import com.example.compartyapp.PartsAdapter;
import com.example.compartyapp.R;
import com.example.compartyapp.ui.gallery.GalleryFragment;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.List;

public class SlideshowFragment extends Fragment {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference partsRef = db.collection("Component");
    private PartsAdapter adapter;
    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        Query query = partsRef.orderBy("productType", Query.Direction.ASCENDING);
//        Query query = partsRef.orderBy("name", Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<Parts> parts = new FirestoreRecyclerOptions.Builder<Parts>()
                .setQuery(query, Parts.class)
                .build();
        //need to get the context of the fragment
        adapter = new PartsAdapter(parts,getContext());

        RecyclerView recyclerView = root.findViewById(R.id.firebase_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}

