package com.androidhunger.webviewexample;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public WebView wv;
    public String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button fb =  (Button) findViewById(R.id.fb);
        Button gp = (Button) findViewById(R.id.gp);
        Button twitter =(Button) findViewById(R.id.twitter);
        Button youtube =(Button) findViewById(R.id.youtube);
        wv = (WebView) findViewById(R.id.webview);

        fb.setOnClickListener(this);
        gp.setOnClickListener(this);
        twitter.setOnClickListener(this);
        youtube.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.fb:
                url = "http://www.facebook.com/androidhungerAH";
                callWebClient(url);
                break;
            case R.id.gp:
                url = "https://plus.google.com/+Androidhunger";
                callWebClient(url);
                break;
            case R.id.twitter:
                url = "http://www.twitter.com/android_hunger";
                callWebClient(url);
                break;
            case R.id.youtube:
                url = "http://www.youtube.com/androidhunger";
                callWebClient(url);
                break;
        }
    }

    private void callWebClient(String url) {
        wv.setWebViewClient(new myWebViewClient());
        wv.getSettings().setLoadsImagesAutomatically(true);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv.loadUrl(url);
    }

    public class myWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stubsuper.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;

        }
    }
}
