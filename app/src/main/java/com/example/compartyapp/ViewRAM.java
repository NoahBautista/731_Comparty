package com.example.compartyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewRAM extends AppCompatActivity {

    ImageView ramImage;
    TextView ramDescription;
    TextView ramFrequency;
    TextView ramMemoryType;
    TextView ramCapacity;
    TextView ramNumberOfSticks;
    TextView ramLink;

    String ramWebURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_r_a_m);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ramImage = (ImageView) findViewById(R.id.ramImage);
        ramDescription = (TextView) findViewById(R.id.textDescriptionRAM);
        ramFrequency = (TextView) findViewById(R.id.textFrequency);
        ramMemoryType = (TextView) findViewById(R.id.textMemoryType);
        ramCapacity = (TextView) findViewById(R.id.textMCapacity);
        ramNumberOfSticks = (TextView) findViewById(R.id.textRamSticks);
        ramLink = (TextView) findViewById(R.id.textLinkRAM);

        Bundle ramBundle = getIntent().getExtras();
        if(ramBundle != null){
            ramImage.setImageResource(ramBundle.getInt("Image"));
            ramDescription.setText(ramBundle.getString("Description"));
            ramNumberOfSticks.setText(String.valueOf(ramBundle.getInt("NumberOfSticks")));
            ramMemoryType.setText(ramBundle.getString("MemoryType"));
            ramCapacity.setText(ramBundle.getString("Capacity"));
            ramFrequency.setText(ramBundle.getString("Frequency"));
            ramWebURL = ramBundle.getString("Link");
        }

        Button ramWebView = findViewById(R.id.ramWebview);
        ramWebView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(com.example.compartyapp.ViewRAM.this,RAMWebView.class);
                intent.putExtra("LINK",ramWebURL);
                startActivity(intent);
            }
        });



    }
}