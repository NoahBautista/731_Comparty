package com.example.compartyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewGPU extends AppCompatActivity {

    ImageView gpuImage;
    TextView gpuDescription;
    TextView gpuCores;
    TextView gpuVRAM;
    TextView gpuBaseClock;
    TextView gpuBoostClock;
    TextView gpuLink;
    TextView gpuPCIEVersion;

    String gpuWebURL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_g_p_u);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gpuImage = (ImageView) findViewById(R.id.gpuImage);
        gpuDescription = (TextView) findViewById(R.id.textDescriptionGPU);
        gpuCores = (TextView) findViewById(R.id.textCores);
        gpuVRAM = (TextView) findViewById(R.id.textVRAM);
        gpuBaseClock = (TextView) findViewById(R.id.textGPUBaseClock);
        gpuBoostClock = (TextView) findViewById(R.id.textGPUBoostClock);
        gpuLink = (TextView) findViewById(R.id.textLinkGPU);
        gpuPCIEVersion = (TextView) findViewById(R.id.textPCIEVersion);

        Bundle gpuBundle = getIntent().getExtras();
        if(gpuBundle != null){
            gpuImage.setImageResource(gpuBundle.getInt("Image"));
            gpuDescription.setText(gpuBundle.getString("Description"));
            gpuCores.setText(String.valueOf(gpuBundle.getInt("Cores")));
            gpuVRAM.setText(String.valueOf(gpuBundle.getInt("VRAM")));
            gpuBaseClock.setText(gpuBundle.getString("GPUBaseClock"));
            gpuBoostClock.setText(gpuBundle.getString("GPUBoostClock"));
            gpuPCIEVersion.setText(gpuBundle.getString("PCIEVersion"));
            gpuWebURL = gpuBundle.getString("Link");
        }

        Button gpuWebView = findViewById(R.id.gpuWebview);
        gpuWebView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(com.example.compartyapp.ViewGPU.this,GPUWebView.class);
                intent.putExtra("LINK",gpuWebURL);
                startActivity(intent);
            }
        });


    }
}