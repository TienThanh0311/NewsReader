package com.example.newsreader;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsreader.Models.Match;

public class MatchViewHolder extends RecyclerView.ViewHolder {

    private TextView tvDate;
    private TextView tvHomeTeam;
    private TextView tvAwayTeam;
    private ImageView ivHomeTeam;
    private ImageView ivAwayTeam;


    public MatchViewHolder(@NonNull View itemView) {
        super(itemView);
        bindingViews();
        bindingAction();
    }

    private void bindingAction() {
        
    }

    private void bindingViews() {
        tvDate = itemView.findViewById(R.id.tvDate);
        tvHomeTeam = itemView.findViewById(R.id.tvHomeTeam);
        tvAwayTeam = itemView.findViewById(R.id.tvAwayTeam);
        ivHomeTeam = itemView.findViewById(R.id.ivHomeLogo);
        ivAwayTeam = itemView.findViewById(R.id.ivAwayLogo);
    }

    public void setMatch(Match match) {
        tvDate.setText(match.getDate() + " " + match.getTime());
        tvHomeTeam.setText(match.getHomeTeam());
        tvAwayTeam.setText(match.getAwayTeam());
        ivHomeTeam.setImageResource(match.getImgHome());
        ivAwayTeam.setImageResource(match.getImgAway());
    }
}
