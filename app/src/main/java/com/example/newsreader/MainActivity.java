package com.example.newsreader;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsreader.Models.Match;
import com.example.newsreader.Models.NewsApiResponse;
import com.example.newsreader.Models.NewsHeadlines;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListener, View.OnClickListener {

    RecyclerView recyclerView;
    CustomerAdapter adapter;
    ProgressDialog dialog;

    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_football;


    private final OnFetchDataListener<NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse>() {

        @Override
        public void onFetchData(List<NewsHeadlines> list, String message) {
            if (list == null || list.isEmpty()) {
                Toast.makeText(MainActivity.this, "No news found", Toast.LENGTH_SHORT).show();
            }else {
                showNews(list);
            }
            dialog.dismiss();
        }

        @Override
        public void onError(String message) {
            Toast.makeText(MainActivity.this, "An Error Occurred", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        }

        };

    private void showNews(List<NewsHeadlines> list) {
        recyclerView = findViewById(R.id.rcView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        adapter = new CustomerAdapter(this, list, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bindingView();
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading News...");
        dialog.show();
        RequestManger manger = new RequestManger(this);
        manger.getNewsHeadlines(listener, "general", null);
    }

    private void bindingView() {
        btn_1 = findViewById(R.id.btn_1);
        btn_1.setOnClickListener(this);
        btn_2 = findViewById(R.id.btn_2);
        btn_2.setOnClickListener(this);
        btn_3 = findViewById(R.id.btn_3);
        btn_3.setOnClickListener(this);
        btn_4 = findViewById(R.id.btn_4);
        btn_4.setOnClickListener(this);
        btn_5 = findViewById(R.id.btn_5);
        btn_5.setOnClickListener(this);
        btn_6 = findViewById(R.id.btn_6);
        btn_6.setOnClickListener(this);
        btn_7 = findViewById(R.id.btn_7);
        btn_7.setOnClickListener(this);
        btn_football = findViewById(R.id.btn_football);
        btn_football.setOnClickListener(this);
    }

    @Override
    public void OnNewsClicked(NewsHeadlines headlines) {
        startActivity(new Intent(MainActivity.this, DetailsActivity.class)
                .putExtra("data", headlines));

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_football) {
            startActivity(new Intent(MainActivity.this, FootballActivity.class));
            return;
        }
        Button button = (Button) v;
        String category = button.getText().toString().toLowerCase();
        dialog.setTitle("Loading " + category + " news...");
        dialog.show();
        RequestManger manger = new RequestManger(this);
        manger.getNewsHeadlines(listener, category, null);
    }
}