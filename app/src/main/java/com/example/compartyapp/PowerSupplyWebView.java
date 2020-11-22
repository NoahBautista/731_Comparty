package com.example.compartyapp;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class PowerSupplyWebView extends AppCompatActivity {
    private WebView webViewPowerSupply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_supply_web_view);
        Bundle powerSupplyWebBundle = getIntent().getExtras();

        webViewPowerSupply = (WebView) findViewById(R.id.webViewPowerSupply);
        webViewPowerSupply.setWebViewClient(new WebViewClient());
        webViewPowerSupply.loadUrl(powerSupplyWebBundle.getString("LINK"));

        WebSettings webSettings = webViewPowerSupply.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if(webViewPowerSupply.canGoBack())
        {
            webViewPowerSupply.goBack();
        }else {
            super.onBackPressed();
        }
    }
    }