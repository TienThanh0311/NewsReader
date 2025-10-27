package com.example.newsreader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsreader.Models.NewsHeadlines;

import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerViewHolder>{

    private Context context;
    private List<NewsHeadlines> headlines;

    private SelectListener listener;

    public CustomerAdapter(Context context, List<NewsHeadlines> headlines, SelectListener listener) {
        this.context = context;
        this.headlines = headlines;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomerViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        holder.text_title.setText(headlines.get(position).getTitle());
        holder.text_source.setText(headlines.get(position).getSource().getName());
        if (headlines.get(position).getUrlToImage() != null) {
            Glide.with(context).load(headlines.get(position).getUrlToImage()).into(holder.imgHeadline);

        }
        holder.main_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnNewsClicked(headlines.get(position));
            }

        });
    }


    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
