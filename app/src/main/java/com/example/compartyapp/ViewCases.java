package com.example.compartyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewCases extends AppCompatActivity {

    ImageView casesImage;
    TextView casesDescription;
    TextView casesSizeSupport;
    TextView casesLink;

    String casesWebURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cases);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        casesImage = (ImageView) findViewById(R.id.casesImage);
        casesDescription = (TextView) findViewById(R.id.textDescriptionCases);
        casesSizeSupport = (TextView) findViewById(R.id.textSizeSupport);
        casesLink = (TextView) findViewById(R.id.textLinkCases);

        Bundle casesBundle = getIntent().getExtras();
        if(casesBundle != null){
            casesImage.setImageResource(casesBundle.getInt("Image"));
            casesDescription.setText(casesBundle.getString("Description"));
            casesSizeSupport.setText(casesBundle.getString("SizeSupport"));
            casesWebURL = casesBundle.getString("Link");
        }

        Button casesWebView = findViewById(R.id.casesWebview);
        casesWebView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(com.example.compartyapp.ViewCases.this,CasesWebView.class);
                intent.putExtra("LINK",casesWebURL);
                startActivity(intent);
            }
        });


    }
}