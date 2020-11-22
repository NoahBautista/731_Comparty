package com.example.compartyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewMotherboard extends AppCompatActivity {

    ImageView motherboardImage;
    TextView motherboardDescription;
    TextView motherboardSize;
    TextView motherboardSocket;
    TextView motherboardRamSupport;
    TextView motherboardPCIESupport;
    TextView motherboardLink;

    String motherboardWebURL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_motherboard);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        motherboardImage = (ImageView) findViewById(R.id.motherboardImage);
        motherboardDescription = (TextView) findViewById(R.id.textDescriptionMotherboard);
        motherboardSize = (TextView) findViewById(R.id.textSize);
        motherboardSocket = (TextView) findViewById(R.id.textSocket);
        motherboardRamSupport = (TextView) findViewById(R.id.textMotherboardRamSupp);
        motherboardPCIESupport = (TextView) findViewById(R.id.textPCIESupp);
        motherboardLink = (TextView) findViewById(R.id.textLinkMotherboard);

        Bundle motherboardBundle = getIntent().getExtras();
        if(motherboardBundle != null){
            motherboardImage.setImageResource(motherboardBundle.getInt("Image"));
            motherboardDescription.setText(motherboardBundle.getString("Description"));
            motherboardSize.setText(motherboardBundle.getString("Size"));
            motherboardSocket.setText(motherboardBundle.getString("Socket"));
            motherboardRamSupport.setText(motherboardBundle.getString("RamSupport"));
            motherboardPCIESupport.setText(motherboardBundle.getString("PCIESupport"));
            motherboardWebURL = motherboardBundle.getString("Link");
        }

        Button motherboardWebView = findViewById(R.id.motherboardWebview);
        motherboardWebView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(com.example.compartyapp.ViewMotherboard.this,MotherboardWebView.class);
                intent.putExtra("LINK",motherboardWebURL);
                startActivity(intent);
            }
        });
    }
}