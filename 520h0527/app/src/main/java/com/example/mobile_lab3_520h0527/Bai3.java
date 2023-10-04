package com.example.mobile_lab3_520h0527;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class Bai3 extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai3);
        webView = findViewById(R.id.web_view);
        Intent intent = getIntent();
        Uri uri = getIntent().getData();
        webView.loadUrl(uri.toString());
    }
}
