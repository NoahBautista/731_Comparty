package com.example.compartyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PartsWebView extends AppCompatActivity {

    private WebView webViewParts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts_web_view);

        Bundle partsWebBundle = getIntent().getExtras();
        webViewParts = (WebView) findViewById(R.id.webViewParts);
        webViewParts.setWebViewClient(new WebViewClient());
        webViewParts.loadUrl(partsWebBundle.getString("LINK"));

        WebSettings webSettings = webViewParts.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if(webViewParts.canGoBack())
        {
            webViewParts.goBack();
        }else {
            super.onBackPressed();
        }
    }
}