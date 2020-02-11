package avicii.m2myworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    String webLink = "https://hkuspace.hku.hk/cc";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webLink = getIntent().getStringExtra("KEY_URL"); // get weblink
        if (webLink.equals("WHERE TO GO")) // display local file for empty text
            webLink = "https://myworldbox.github.io"; // my pubished website on GitHub
        WebView aWebView = (WebView)findViewById(R.id.webView);
        WebSettings aWebSettings = aWebView.getSettings();
        aWebSettings.setJavaScriptEnabled(true); // enable JavaScript usage
        aWebView.loadUrl(webLink); // display the web
        aWebView.setWebViewClient(new WebViewClient()); // set to display on webView
    }

}
