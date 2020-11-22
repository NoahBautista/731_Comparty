package com.example.compartyapp;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class RAMWebView extends AppCompatActivity {

    private WebView webViewRAM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_a_m_web_view);

        Bundle ramWebBundle = getIntent().getExtras();

        webViewRAM = (WebView) findViewById(R.id.webViewRAM);
        webViewRAM.setWebViewClient(new WebViewClient());
        webViewRAM.loadUrl(ramWebBundle.getString("LINK"));

        WebSettings webSettings = webViewRAM.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if(webViewRAM.canGoBack())
        {
            webViewRAM.goBack();
        }else {
            super.onBackPressed();
        }
    }
    }