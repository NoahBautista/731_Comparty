package com.example.compartyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PartsView extends AppCompatActivity {

    TextView partsDescription;
    TextView partsManufacturer;
    TextView partsPrice;
    TextView partsLink;
    TextView partsName;
    TextView partsProductType;

    String partsWebURL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts_view);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        partsDescription = (TextView) findViewById(R.id.textDescriptionP);
        partsProductType = (TextView) findViewById(R.id.textProductType);
        partsManufacturer = (TextView) findViewById(R.id.textManufacturer);
        partsPrice = (TextView) findViewById(R.id.textPrice);
        partsLink = (TextView) findViewById(R.id.textLinkP);
        partsName = (TextView) findViewById(R.id.textNameP);

        Bundle partsBundle = getIntent().getExtras();
        if(partsBundle != null){
            partsDescription.setText(partsBundle.getString("Description"));
            partsPrice.setText(String.valueOf(partsBundle.getDouble("Price")));
            partsManufacturer.setText(partsBundle.getString("Manufacturer"));
            partsProductType.setText(partsBundle.getString("ProductType"));
            partsWebURL = partsBundle.getString("Link");
            // Added
            partsName.setText(partsBundle.getString("NameP"));
        }


//        Button partsWebView = findViewById(R.id.partsWebView);
//        partsWebView.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                Intent intent = new Intent(com.example.compartyapp.ViewCPU.this,CPUWebView.class);
//                intent.putExtra("LINK",cpuWebURL);
//                startActivity(intent);
//            }
//        });

    }
}