package com.example.newsreader;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.newsreader.Models.NewsHeadlines;

public class DetailsActivity extends AppCompatActivity {

    NewsHeadlines headlines;

    TextView text_title, text_author, text_time, text_detail;

    WebView webView_content;

    ImageView img_news;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bindingView();
        headlines = (NewsHeadlines) getIntent().getSerializableExtra("data");
        text_title.setText(headlines.getTitle());
        text_author.setText(headlines.getAuthor());
        text_time.setText(headlines.getPublishedAt());
        text_detail.setText(headlines.getDescription());
        webView_content.setWebViewClient(new WebViewClient()); // Giúp trang web mở ngay trong app
        webView_content.getSettings().setJavaScriptEnabled(true); // Bật JavaScript cho các trang web hiện đại
        webView_content.loadUrl(headlines.getUrl());
        Glide.with(this).load(headlines.getUrlToImage()).into(img_news);
    }

    private void bindingView() {
        text_title = findViewById(R.id.text_detail_title);
        text_author = findViewById(R.id.text_detail_author);
        text_time = findViewById(R.id.text_detail_time);
        text_detail = findViewById(R.id.text_detail_detail);
        webView_content = findViewById(R.id.webview_detail_content);
//        text_content = findViewById(R.id.text_detail_content);
        img_news = findViewById(R.id.img_detail_news);
    }
}