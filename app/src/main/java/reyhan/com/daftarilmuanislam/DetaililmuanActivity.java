package reyhan.com.daftarilmuanislam;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DetaililmuanActivity extends AppCompatActivity {

    WebView webView;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaililmuan);

        webView = findViewById(R.id.webDetail);
        String nama = getIntent().getStringExtra("NAMA");
        String url = getIntent().getStringExtra("URL");


        getSupportActionBar().setTitle("Bio" + nama);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);


        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);

    }
}
