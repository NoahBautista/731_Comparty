package com.example.compartyapp;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class CasesWebView extends AppCompatActivity {
    private WebView webViewCases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases_web_view);
        Bundle powerSupplyWebBundle = getIntent().getExtras();

        webViewCases = (WebView) findViewById(R.id.webViewCases);
        webViewCases.setWebViewClient(new WebViewClient());
        webViewCases.loadUrl(powerSupplyWebBundle.getString("LINK"));

        WebSettings webSettings = webViewCases.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if(webViewCases.canGoBack())
        {
            webViewCases.goBack();
        }else {
            super.onBackPressed();
        }
    }
    }