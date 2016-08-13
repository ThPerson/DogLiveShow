package com.example.mypc.dogliveshow.main.ui.headlinefragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.example.mypc.dogliveshow.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HeadLineWeb extends AppCompatActivity {

    @BindView(R.id.web_head_line)
    WebView webHeadLine;
    @BindView(R.id.iv_web_back)
    ImageView ivWebBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_line_web);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");

        WebSettings settings = webHeadLine.getSettings();
        webHeadLine.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        settings.setJavaScriptEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webHeadLine.loadUrl(url);
        webHeadLine.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }



    @OnClick(R.id.iv_web_back)
    public void onClick() {
        onBackPressed();
    }
}
