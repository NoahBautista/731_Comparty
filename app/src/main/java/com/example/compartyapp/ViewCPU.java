package com.example.compartyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewCPU extends AppCompatActivity {

    ImageView cpuImage;
    TextView cpuDescription;
    TextView cpuNumberOfCores;
    TextView cpuNumberOfThreads;
    TextView cpuBaseClock;
    TextView cpuBoostClock;
    TextView cpuLink;

    String cpuWebURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_c_p_u);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cpuImage = (ImageView) findViewById(R.id.cpuImage);
        cpuDescription = (TextView) findViewById(R.id.textDescription);
        cpuNumberOfCores = (TextView) findViewById(R.id.textNumberOfCores);
        cpuNumberOfThreads = (TextView) findViewById(R.id.textNumberOfThreads);
        cpuBaseClock = (TextView) findViewById(R.id.textBaseClock);
        cpuBoostClock = (TextView) findViewById(R.id.textBoostClock);
        cpuLink = (TextView) findViewById(R.id.textLink);

        Bundle cpuBundle = getIntent().getExtras();
        if(cpuBundle != null){
            cpuImage.setImageResource(cpuBundle.getInt("Image"));
            cpuDescription.setText(cpuBundle.getString("Description"));
            cpuNumberOfCores.setText(String.valueOf(cpuBundle.getInt("NumberOfCores")));
            cpuNumberOfThreads.setText(String.valueOf(cpuBundle.getInt("NumberOfThreads")));
            cpuBaseClock.setText(cpuBundle.getString("BaseClock"));
            cpuBoostClock.setText(cpuBundle.getString("BoostClock"));
            cpuWebURL = cpuBundle.getString("Link");
        }

        Button cpuWebView = findViewById(R.id.cpuWebview);
        cpuWebView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(com.example.compartyapp.ViewCPU.this,CPUWebView.class);
                intent.putExtra("LINK",cpuWebURL);
                startActivity(intent);
            }
        });

    }
}