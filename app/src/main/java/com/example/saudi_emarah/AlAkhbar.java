package com.example.saudi_emarah;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AlAkhbar extends AppCompatActivity {
    private WebView webView;
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //This is used to hide/show 'Status Bar' & 'System Bar'. Swip bar to get it as visible.
        View decorView = getWindow().getDecorView();
        if (hasFocus) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al_akhbar);

        webView = (WebView) findViewById(R.id.webview);
     //   webView.getSettings().setAppCacheEnabled(false);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setInitialScale(1);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setEnableSmoothTransition(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);
        webSettings.setUseWideViewPort(true);

        //  setContentView(webView);
        webView.loadUrl("https://www.moi.gov.sa/wps/portal/Home/emirates/najran/!ut/p/z1/04_Sj9CPykssy0xPLMnMz0vMAfIjo8ziLQPdnT08TIy83Q0dzQwcPc2N_A08TQ3dPY30wwkpiAJKG-AAjgZA_VFgJc7ujh4m5j4GBhY-7qYGno4eoUGWgcbGBo7GUAV4zAhOLNIvyI0wyDJxVAQAWYyrQQ!!/dz/d5/L2dJQSEvUUt3QS80TmxFL1o2XzBJNDRIMTQySzhGQzUwQVFNMEE3VEIzOEQ0/");
    }

}

