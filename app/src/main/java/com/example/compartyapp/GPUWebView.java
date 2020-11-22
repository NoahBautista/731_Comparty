package com.example.compartyapp;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class GPUWebView extends AppCompatActivity {

    private WebView webViewGPU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_p_u_web_view);

        Bundle gpuWebBundle = getIntent().getExtras();

        webViewGPU = (WebView) findViewById(R.id.webViewGPU);
        webViewGPU.setWebViewClient(new WebViewClient());
        webViewGPU.loadUrl(gpuWebBundle.getString("LINK"));

        WebSettings webSettings = webViewGPU.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if(webViewGPU.canGoBack())
        {
            webViewGPU.goBack();
        }else {
            super.onBackPressed();
        }
    }
    }