package com.example.compartyapp;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MotherboardWebView extends AppCompatActivity {

    private WebView webViewMotherboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motherboard_web_view);
        Bundle motherboardWebBundle = getIntent().getExtras();

        webViewMotherboard = (WebView) findViewById(R.id.webViewMotherboard);
        webViewMotherboard.setWebViewClient(new WebViewClient());
        webViewMotherboard.loadUrl(motherboardWebBundle.getString("LINK"));

        WebSettings webSettings = webViewMotherboard.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if(webViewMotherboard.canGoBack())
        {
            webViewMotherboard.goBack();
        }else {
            super.onBackPressed();
        }
    }
}