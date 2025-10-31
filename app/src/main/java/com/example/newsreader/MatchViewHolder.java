package com.example.newsreader;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsreader.Models.Match;

public class MatchViewHolder extends RecyclerView.ViewHolder {

    private TextView tvDate;
    private TextView tvHomeTeam;
    private TextView tvAwayTeam;
    private ImageView ivHomeTeam;
    private ImageView ivAwayTeam;

    private Match currentMatch;

    public MatchViewHolder(@NonNull View itemView) {
        super(itemView);
        bindingViews();
        bindingAction();
    }

    private void bindingAction() {
        tvDate.setOnLongClickListener(this::OnLongClickTvDate);
    }

    private boolean OnLongClickTvDate(View view) {
        startDetailActivity();
        return true;
    }

    private void startDetailActivity() {
        if (currentMatch != null) {
            int matchId = currentMatch.getId();

            if (matchId != 0) {
                Intent i = new Intent(itemView.getContext(), MatchDetail.class);
                i.putExtra("matchId", matchId);
                itemView.getContext().startActivity(i);
            }
        }
    }

    private void bindingViews() {
        tvDate = itemView.findViewById(R.id.tvDate);
        tvHomeTeam = itemView.findViewById(R.id.tvHomeTeam);
        tvAwayTeam = itemView.findViewById(R.id.tvAwayTeam);
        ivHomeTeam = itemView.findViewById(R.id.ivHomeLogo);
        ivAwayTeam = itemView.findViewById(R.id.ivAwayLogo);
    }

    public void setMatch(Match match) {
        currentMatch = match;
        tvDate.setText(match.getDate() + " " + match.getTime());
        tvHomeTeam.setText(match.getHomeTeam());
        tvAwayTeam.setText(match.getAwayTeam());
        ivHomeTeam.setImageResource(match.getImgHome());
        ivAwayTeam.setImageResource(match.getImgAway());
    }
}
