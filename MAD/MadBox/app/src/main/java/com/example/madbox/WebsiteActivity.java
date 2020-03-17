package com.example.madbox;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

//this class handles all webView events
public class WebsiteActivity extends MainActivity {

    WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        SharedPreferences settings2 = this.getSharedPreferences(PREFS_NAME, 2);
        website = settings2.getString("key2", "");

        //open website depending on button clicked
        webView = findViewById(R.id.webViewId);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(website);
    }
}
