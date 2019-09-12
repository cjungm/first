package com.gmail.candy7manner.fifteenth_web;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends AppCompatActivity {

    WebView wv;
    EditText etUrl;
    Button btnWebView, btnBrowser;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etUrl = findViewById(R.id.etUrl);
        wv = findViewById(R.id.wv);
        btnWebView = findViewById(R.id.btnWebView);
        btnBrowser = findViewById(R.id.btnBrowser);

        //String myMsg = getResources().getString(R.string.msg);

        // WebView 세팅
        wv.getSettings().setJavaScriptEnabled(true);  // 디폴트 false, JavaScript 사용여부

        btnWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = etUrl.getText().toString().trim();
                wv.loadUrl(url);  // 접속 url (request 발생)
                wv.setWebChromeClient(new WebChromeClient());  // 안하면 alert() 같은 알림창 안뜸.
                wv.setWebViewClient(new WebViewClientClass());  // 안하면 html 내부에서 다른 페이지 이동이 안됨.
            }
        });

        btnBrowser.setOnClickListener(new View.OnClickListener() {
            // 내장 기본 브라우저에 웹화면 띄우기
            // implicit intent 사용
            @Override
            public void onClick(View view) {
                url = etUrl.getText().toString().trim();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    } // end onCreate()


    private class WebViewClientClass extends WebViewClient {
        @SuppressWarnings("deprecation")
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d("myapp", "Check URL " + url);
            view.loadUrl(url);
            return true;
        }
    }
}