package com.example.compartyapp;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class CPUWebView extends AppCompatActivity {

    private WebView webViewCPU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_p_u_web_view);

        Bundle cpuWebBundle = getIntent().getExtras();

        webViewCPU = (WebView) findViewById(R.id.webViewCPU);
        webViewCPU.setWebViewClient(new WebViewClient());
        webViewCPU.loadUrl(cpuWebBundle.getString("LINK"));

        WebSettings webSettings = webViewCPU.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if(webViewCPU.canGoBack())
        {
            webViewCPU.goBack();
        }else {
            super.onBackPressed();
        }
        }
}