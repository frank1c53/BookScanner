package com.organization.bookscanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

public class WebviewActivity extends AppCompatActivity {
    private WebView webview;
    private static final String TAG = "Main";
    private ProgressDialog progressBar;
    private String Stringdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        Bundle bundle = getIntent().getExtras();
        //webview = (WebView)findViewById(R.id.webview);
        Stringdata = bundle.getString("StringData");

        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        int colorInt = Color.parseColor("#FF0000"); //red
        CustomTabColorSchemeParams defaultColors = new CustomTabColorSchemeParams.Builder()
                .setToolbarColor(colorInt)
                .build();
        builder.setDefaultColorSchemeParams(defaultColors);
        customTabsIntent.launchUrl(this, Uri.parse(Stringdata));
    }
}