package com.stmikbumigora.apps.menuNavigation;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

import com.stmikbumigora.apps.AboutMe;
import com.stmikbumigora.apps.MainActivity;
import com.stmikbumigora.apps.R;

public class Nav_Sejarah extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav__sejarah);

        Nav_Sejarah.this.setTitle("Sejarah");
        WebView webView = (WebView) findViewById(R.id.webview);
        WebView webViewt = (WebView) findViewById(R.id.webviewt);
        WebView webView2 = (WebView) findViewById(R.id.webview2);
        WebView webView3 = (WebView) findViewById(R.id.webview3);
        WebView webView4 = (WebView) findViewById(R.id.webview4);
        WebView webView5 = (WebView) findViewById(R.id.webview5);
        WebView webView6 = (WebView) findViewById(R.id.webview6);
        WebView webView7 = (WebView) findViewById(R.id.webview7);
        //        webView.loadData("<p style=\"text-align: justify\">"+text+"</p>","text/html","UTF-8");
        webView.loadData(getString(R.string.sejarah), "text/html; charset=utf-8", "utf-8");
        webViewt.loadData(getString(R.string.sejaraht), "text/html; charset=utf-8", "utf-8");
        webView2.loadData(getString(R.string.sejarah2), "text/html; charset=utf-8", "utf-8");
        webView3.loadData(getString(R.string.sejarah3), "text/html; charset=utf-8", "utf-8");
        webView4.loadData(getString(R.string.sejarah4), "text/html; charset=utf-8", "utf-8");
        webView5.loadData(getString(R.string.sejarah5), "text/html; charset=utf-8", "utf-8");
        webView6.loadData(getString(R.string.sejarah6), "text/html; charset=utf-8", "utf-8");
        webView7.loadData(getString(R.string.sejarah7), "text/html; charset=utf-8", "utf-8");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_satu_sejarah);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public void onBackPressed() {
//        startActivity(new Intent(Nav_Sejarah.this, MainActivity.class));
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
