package com.example.newsreader;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomerViewHolder extends RecyclerView.ViewHolder {

    TextView text_title;
    TextView text_source;

    ImageView imgHeadline;

    CardView main_container;



    public CustomerViewHolder(@NonNull View itemView) {
        super(itemView);
        bindingView();
        bindingAction();
    }

    private void bindingAction() {
    }

    private void bindingView() {
        text_title = itemView.findViewById(R.id.text_title);
        text_source = itemView.findViewById(R.id.text_source);
        imgHeadline = itemView.findViewById(R.id.img_headline);
        main_container = itemView.findViewById(R.id.main_container);

    }
}
