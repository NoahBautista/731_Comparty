package com.example.compartyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewPowerSupply extends AppCompatActivity {

    ImageView powerSupplyImage;
    TextView powerSupplyDescription;
    TextView powerSupplyType;
    TextView powerSupplyCapacity;
    TextView powerSupplyRating;
    TextView powerSupplyLink;

    String powerSupplyWebURL;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_power_supply);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        powerSupplyImage = (ImageView) findViewById(R.id.powerSupplyImage);
        powerSupplyDescription = (TextView) findViewById(R.id.textDescriptionPowerSupply);
        powerSupplyType = (TextView) findViewById(R.id.textPType);
        powerSupplyCapacity = (TextView) findViewById(R.id.textPCapacity);
        powerSupplyRating = (TextView) findViewById(R.id.textRating);
        powerSupplyLink = (TextView) findViewById(R.id.textLinkPowerSupply);

        Bundle powerSupplyBundle = getIntent().getExtras();
        if(powerSupplyBundle != null){
            powerSupplyImage.setImageResource(powerSupplyBundle.getInt("Image"));
            powerSupplyDescription.setText(powerSupplyBundle.getString("Description"));
            powerSupplyType.setText(powerSupplyBundle.getString("PType"));
            powerSupplyCapacity.setText(powerSupplyBundle.getString("PCapacity"));
            powerSupplyRating.setText(powerSupplyBundle.getString("Rating"));
            powerSupplyWebURL = powerSupplyBundle.getString("Link");
        }

        Button powerSupplyWebView = findViewById(R.id.powerSupplyWebview);
        powerSupplyWebView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(com.example.compartyapp.ViewPowerSupply.this,PowerSupplyWebView.class);
                intent.putExtra("LINK",powerSupplyWebURL);
                startActivity(intent);
            }
        });


    }
}