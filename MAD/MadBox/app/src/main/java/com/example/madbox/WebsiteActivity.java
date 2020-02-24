package com.example.madbox;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

//this class handles all webView events
public class WebsiteActivity extends BaseActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        GetKey();

        //open website depending on button clicked
        WebView webView;
        webView = findViewById(R.id.webViewId);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(website);
    }

    @Override
    protected void onResume() {
        super.onResume();

        HideNav();
        RandMusic();
        MusicOn();
    }

    @Override
    protected void onPause() {
        super.onPause();

        MusicOff();
    }
}
