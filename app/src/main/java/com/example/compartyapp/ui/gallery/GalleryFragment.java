package com.example.compartyapp.ui.gallery;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.compartyapp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private static final String TAG = "GalleryFragment";

    private static final String KEY_TITLE = "name";
    private static final String KEY_DESC = "description";
    private static final String KEY_MANU = "manufacturer";
    private static final String KEY_LINK = "link";
    private static final String KEY_PRICE = "price";
    private static final String KEY_TYPE = "productType";

    private EditText editTextTitle;
    private EditText editTextDescription;
    private EditText editTextManufacturer;
    private EditText editTextLink;
    private EditText editTextPrice;
    private EditText editTextType;
    private TextView textViewData;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference componentRef = db.collection("Component");
    private DocumentReference noteRef;
    private ListenerRegistration componentListner;


    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        noteRef = db.document("Component/Default");
        editTextTitle = root.findViewById(R.id.edit_text_title);
        editTextDescription = root.findViewById(R.id.edit_text_description);
        editTextManufacturer = root.findViewById(R.id.edit_text_manufacturer);
        editTextLink = root.findViewById(R.id.edit_text_link);
        editTextPrice= root.findViewById(R.id.edit_text_price);
        editTextType = root.findViewById(R.id.edit_text_type);
        textViewData = root.findViewById(R.id.text_view_data);

        Button b1 = (Button) root.findViewById(R.id.button_save);
        b1.setOnClickListener(buttonSave);

//        Button b2 = (Button) root.findViewById(R.id.button_load);
//        b2.setOnClickListener(buttonLoad);

        Button b3 = (Button) root.findViewById(R.id.button_update);
        b3.setOnClickListener(buttonUpdate);

        Button b4 = (Button) root.findViewById(R.id.button_delete);
        b4.setOnClickListener(buttonDelete);
        return root;
    }

    @Override
    public void onStart()
    {
        super.onStart();
//        componentListner= noteRef.addSnapshotListener(getActivity(),new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
//                if(error != null)
//                {
//                    Toast.makeText(getActivity(), "Error While Loading!", Toast.LENGTH_SHORT).show();
//                    Log.d(TAG, error.toString());
//                    return;
//                }
//
//                if(documentSnapshot.exists()){
//                    String title = documentSnapshot.getString(KEY_TITLE);
//                    String description = documentSnapshot.getString(KEY_DESC);
//                    String manufacturer = documentSnapshot.getString(KEY_MANU);
//                    String link = documentSnapshot.getString(KEY_LINK);
//                    Double price = documentSnapshot.getDouble(KEY_PRICE);
//                    String type = documentSnapshot.getString(KEY_TYPE);
//
//                    textViewData.setText("Name: " +title+ "\n" +"Description: "+description+ "\n" +"Manufacturer: "+manufacturer+"\n" +"Link: "+link+ "\n" +"Price : "+price+ "\n" +"ProductType: "+type );
//                }
//            }
//        });
        componentRef.addSnapshotListener(getActivity(), new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error != null)
                {
                    return;
                }

                String data ="";
                for(QueryDocumentSnapshot documentSnapshot: value)
                {
                    String title = documentSnapshot.getString(KEY_TITLE);
                    String description = documentSnapshot.getString(KEY_DESC);
                    String manufacturer = documentSnapshot.getString(KEY_MANU);
                    String link = documentSnapshot.getString(KEY_LINK);
                    Double price = documentSnapshot.getDouble(KEY_PRICE);
                    String type = documentSnapshot.getString(KEY_TYPE);
                    data += "Name: " +title+ "\n" +"Description: "+description+ "\n" +"Manufacturer: "+manufacturer+"\n" +"Link: "+link+ "\n" +"Price : "+price+ "\n" +"ProductType: "+type + "\n\n";
                }

                textViewData.setText(data);
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        // componentListner.remove();
    }

    private View.OnClickListener buttonSave = new View.OnClickListener() {
        public void onClick(View v) {
//            if(editTextTitle == null || editTextDescription == null || editTextManufacturer == null  || editTextLink == null  || editTextPrice == null || editTextType == null  ){
//                Toast.makeText(getActivity(), "Please insert data into all fields.", Toast.LENGTH_SHORT).show();
//                return;
//            }
            saveNote(v);
        }
    };

    private View.OnClickListener buttonLoad = new View.OnClickListener() {
        public void onClick(View v) {
            loadNote(v);
        }
    };

    private View.OnClickListener buttonUpdate = new View.OnClickListener() {
        public void onClick(View v) {
            updateNote(v);
        }
    };

    private View.OnClickListener buttonDelete = new View.OnClickListener() {
        public void onClick(View v) {
            deleteNote(v);
        }
    };

    private void deleteNote(View v) {
        try {
            if (editTextTitle.getText().toString() != null) {
                noteRef = db.document("Component/" + editTextTitle.getText().toString());
                noteRef.delete();
                Toast.makeText(getActivity(), "Component Deleted", Toast.LENGTH_SHORT).show();
            }
        }
        catch (IllegalArgumentException exception){
            Toast.makeText(getActivity(), "Input a valid component name present in the build section.", Toast.LENGTH_LONG).show();
        }
    }

    public void updateNote(View v) {
        try {
            if (editTextTitle.getText().toString() != null) {
                noteRef = db.document("Component/" + editTextTitle.getText().toString());
                String description = editTextDescription.getText().toString();
                // Map<String, Object> note = new HashMap<>();
                // note.put(KEY_DESC, description);
                //noteRef = db.document("Component/"+KEY_TITLE);
                String manufacturer = editTextManufacturer.getText().toString();
                String link = editTextLink.getText().toString();
                String type = editTextType.getText().toString();
                Double price = Double.parseDouble(editTextPrice.getText().toString());

                noteRef.update(KEY_DESC, description);
                noteRef.update(KEY_MANU, manufacturer);
                noteRef.update(KEY_LINK, link);
                noteRef.update(KEY_TYPE, type);
                noteRef.update(KEY_PRICE, price);
                Toast.makeText(getActivity(), "Component Updated", Toast.LENGTH_SHORT).show();
            }
        }
        catch (IllegalArgumentException exception){
            Toast.makeText(getActivity(), "Input a valid component name present in the build section.", Toast.LENGTH_LONG).show();
        }
    }

    public void saveNote(View v)
    {

        String title = editTextTitle.getText().toString();
        try{
            noteRef = db.document("Component/"+title);
            String description = editTextDescription.getText().toString();
            String manufacturer = editTextManufacturer.getText().toString();
            String link = editTextLink.getText().toString();
            Double price = Double.parseDouble(editTextPrice.getText().toString());
            String type = editTextType.getText().toString();

            if(editTextTitle == null || editTextDescription == null || editTextManufacturer == null  || editTextLink == null  || editTextPrice == null || editTextType == null  ){
                Toast.makeText(getActivity(), "Please valid data into all fields.", Toast.LENGTH_SHORT).show();
            }
            else{
                Map<String, Object> note = new HashMap<>();
                note.put(KEY_DESC, description);
                note.put(KEY_LINK, link);
                note.put(KEY_MANU, manufacturer);
                note.put(KEY_TITLE, title);
                note.put(KEY_PRICE, price);
                note.put(KEY_TYPE, type);
                componentRef.document(title).set(note);
                Toast.makeText(getActivity(), "Component Added.", Toast.LENGTH_SHORT).show();
            }

//        noteRef.set(note)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        Toast.makeText(getActivity(), "Note saved", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(getActivity(), "Error!", Toast.LENGTH_SHORT).show();
//                        Log.d(TAG, e.toString());
//                    }
//                });

        }
        catch (IllegalArgumentException exception){
            Toast.makeText(getActivity(), "Please insert data into all fields.", Toast.LENGTH_SHORT).show();
        }
    }

    public void loadNote(View v) {
        noteRef = db.document("Component/"+editTextTitle.getText().toString());
        noteRef.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){
                            String title = documentSnapshot.getString(KEY_TITLE);
                            String description = documentSnapshot.getString(KEY_DESC);
                            String manufacturer = documentSnapshot.getString(KEY_MANU);
                            String link = documentSnapshot.getString(KEY_LINK);
                            Double price = documentSnapshot.getDouble(KEY_PRICE);
                            String type = documentSnapshot.getString(KEY_TYPE);

                            //Map<String, Object> note = documentSnapshot.getData();

                            textViewData.setText("Name: " +title+ "\n" +"Description: "+description+ "\n" +"Manufacturer: "+manufacturer+"\n" +"Link: "+link+ "\n" +"Price : "+price+ "\n" +"ProductType: "+type );
                        } else {
                            Toast.makeText(getActivity(), "Document does not exist", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getActivity(), "Error!", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, e.toString());
                    }
                });
    }
//        componentRef.get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        String data ="";
//                        for(QueryDocumentSnapshot documentSnapshot: queryDocumentSnapshots)
//                        {
//                            String title = documentSnapshot.getString(KEY_TITLE);
//                          String description = documentSnapshot.getString(KEY_DESC);
//                          String manufacturer = documentSnapshot.getString(KEY_MANU);
//                          String link = documentSnapshot.getString(KEY_LINK);
//                          Double price = documentSnapshot.getDouble(KEY_PRICE);
//                          String type = documentSnapshot.getString(KEY_TYPE);
//                          data += "Name: " +title+ "\n" +"Description: "+description+ "\n" +"Manufacturer: "+manufacturer+"\n" +"Link: "+link+ "\n" +"Price : "+price+ "\n" +"ProductType: "+type + "\n\n";
//                        }
//
//                        textViewData.setText(data);
//                    }
//                });
//    }
}