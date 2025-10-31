package com.example.newsreader;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.newsreader.Models.Match;

import java.util.ArrayList;

public class MatchDetail extends AppCompatActivity {

    private TextView tvDate;
    private TextView tvHomeTeam;
    private TextView tvAwayTeam;
    private ImageView ivHomeTeam;
    private ImageView ivAwayTeam;

    private TextView tvHomeWin;
    private TextView tvDraw;
    private TextView tvAwayWin;;

    private TextView tvOddHome;
    private TextView tvOddDraw;
    private TextView tvOddAway;
    private DBMatchContext db;

    private Button btnLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.match_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.match_detail), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        
        bindingView();
        bindingAction();

    }

    private void bindingAction() {
        onReceivedIntent();
        btnLink.setOnClickListener(this::onBtnLinkClick);
    }

    private void onBtnLinkClick(View view) {
        String url = "https://90phuttv.link/";

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        if (browserIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(browserIntent);
        } else {
            Toast.makeText(this, "Không tìm thấy ứng dụng trình duyệt.", Toast.LENGTH_SHORT).show();
        }
    }

    private void onReceivedIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            int matchId = intent.getIntExtra("matchId", -1);

            if (matchId != -1) {
                loadMatchDetail(matchId);
            } else {
                Toast.makeText(this, "Match ID not found", Toast.LENGTH_SHORT).show();
                finish();
            }

        }
    }

    private void loadMatchDetail(int matchId) {
        Match match = null;
        Cursor cursor = db.getMatchById(matchId);
        try {
            cursor = db.getMatchById(matchId);

            if (cursor != null && cursor.moveToFirst()) {

                // Lấy ID và các cột khác chính xác
                int idIndex = cursor.getColumnIndexOrThrow(DBMatchContext.COL_MATCH_ID);
                int id = cursor.getInt(idIndex);
                String date = cursor.getString(cursor.getColumnIndexOrThrow(DBMatchContext.COL_DATE));
                String homeTeam = cursor.getString(cursor.getColumnIndexOrThrow(DBMatchContext.COL_HOME_TEAM));
                String awayTeam = cursor.getString(cursor.getColumnIndexOrThrow(DBMatchContext.COL_AWAY_TEAM));
                String time = cursor.getString(cursor.getColumnIndexOrThrow(DBMatchContext.COL_TIME));
                int winHome = cursor.getInt(cursor.getColumnIndexOrThrow(DBMatchContext.COL_WIN_HOME));
                int draw = cursor.getInt(cursor.getColumnIndexOrThrow(DBMatchContext.COL_DRAW));
                int winAway = cursor.getInt(cursor.getColumnIndexOrThrow(DBMatchContext.COL_WIN_AWAY));
                double oddHome = cursor.getDouble(cursor.getColumnIndexOrThrow(DBMatchContext.COL_ODD_HOME));
                double oddDraw = cursor.getDouble(cursor.getColumnIndexOrThrow(DBMatchContext.COL_ODD_DRAW));
                double oddAway = cursor.getDouble(cursor.getColumnIndexOrThrow(DBMatchContext.COL_ODD_AWAY));
                int imgHome = cursor.getInt(cursor.getColumnIndexOrThrow(DBMatchContext.COL_IMG_HOME));
                int imgAway = cursor.getInt(cursor.getColumnIndexOrThrow(DBMatchContext.COL_IMG_AWAY));

                match = new Match( id,date, homeTeam, awayTeam, time, winHome, draw, winAway, oddHome, oddDraw, oddAway, imgHome, imgAway);

            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Lỗi khi đọc CSDL: " + e.getMessage(), Toast.LENGTH_LONG).show();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        if (match != null) {
            tvDate.setText(match.getDate() + " " + match.getTime());
            tvHomeTeam.setText(match.getHomeTeam());
            tvAwayTeam.setText(match.getAwayTeam());
            ivHomeTeam.setImageResource(match.getImgHome());
            ivAwayTeam.setImageResource(match.getImgAway());
            tvHomeWin.setText(String.valueOf(match.getWinHome()));
            tvDraw.setText(String.valueOf(match.getDraw()));
            tvAwayWin.setText(String.valueOf(match.getWinAway()));
            tvOddHome.setText(String.valueOf(match.getOddHome()));
            tvOddDraw.setText(String.valueOf(match.getOddDraw()));
            tvOddAway.setText(String.valueOf(match.getOddAway()));
        } else {
            Toast.makeText(this, "Match not found", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void bindingView() {
        tvDate = findViewById(R.id.tvDate);
        tvHomeTeam = findViewById(R.id.tvHomeTeam);
        tvAwayTeam = findViewById(R.id.tvAwayTeam);
        ivHomeTeam = findViewById(R.id.ivHomeLogo);
        ivAwayTeam = findViewById(R.id.ivAwayLogo);
        tvHomeWin = findViewById(R.id.tvHomeWin);
        tvDraw = findViewById(R.id.tvDraw);
        tvAwayWin = findViewById(R.id.tvAwayWin);
        tvOddHome = findViewById(R.id.tvOddHome);
        tvOddDraw = findViewById(R.id.tvOddDraw);
        tvOddAway = findViewById(R.id.tvOddAway);
        btnLink = findViewById(R.id.btnLink);
        db = new DBMatchContext(this);
    }
}
