package com.example.newsreader;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsreader.Models.Match;

import java.util.ArrayList;

public class FootballActivity extends AppCompatActivity {

    private RecyclerView rcvMatch;

    private DBMatchContext db;

    private ArrayList<Match> matches = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_football);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.schedule), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bindingView();
        bindingAction();
        onPrepareMatch();
    }

    private void onPrepareMatch() {
        matches.clear();
        Cursor cursor = db.getAllMatches();
        if (cursor.moveToFirst()) {
            do {
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

                Match match = new Match( id,date, homeTeam, awayTeam, time, winHome, draw, winAway, oddHome, oddDraw, oddAway, imgHome, imgAway);

                matches.add(match);

            } while (cursor.moveToNext());
        }
        cursor.close();

        MatchAdapter adapter = new MatchAdapter(matches, this);
        rcvMatch.setLayoutManager(new LinearLayoutManager(this));
        rcvMatch.setAdapter(adapter);

        if (matches.isEmpty()) {
            Toast.makeText(this, "No matches found", Toast.LENGTH_SHORT).show();
        }
    }

    private void bindingAction() {
    }

    private void bindingView() {
        db = new DBMatchContext(this);
        rcvMatch = findViewById(R.id.rcvMatches);
    }
}
