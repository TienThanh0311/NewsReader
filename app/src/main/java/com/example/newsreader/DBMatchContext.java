package com.example.newsreader;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBMatchContext extends SQLiteOpenHelper {
    private static final String DB_NAME = "Schedule.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "matches";

    public static final String COL_MATCH_ID = "id";
    public static final String COL_DATE = "date";
    public static final String COL_HOME_TEAM = "homeTeam";
    public static final String COL_AWAY_TEAM = "awayTeam";
    public static final String COL_TIME = "time";

    public static final String COL_WIN_HOME = "winHome";
    public static final String COL_DRAW = "draw";
    public static final String COL_WIN_AWAY = "winAway";

    public static final String COL_ODD_HOME = "oddHome";
    public static final String COL_ODD_DRAW = "oddDraw";
    public static final String COL_ODD_AWAY = "oddAway";

    public static final String COL_IMG_HOME = "imgHome";
    public static final String COL_IMG_AWAY = "imgAway";


    public DBMatchContext(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "("
                + COL_DATE + " TEXT,"
                + COL_HOME_TEAM + " TEXT,"
                + COL_AWAY_TEAM + " TEXT,"
                + COL_TIME + " TEXT,"
                + COL_WIN_HOME + " INTEGER,"
                + COL_DRAW + " INTEGER,"
                + COL_WIN_AWAY + " INTEGER,"
                + COL_ODD_HOME + " REAL,"
                + COL_ODD_DRAW + " REAL,"
                + COL_ODD_AWAY + " REAL,"
                + COL_IMG_HOME + " INTEGER,"
                + COL_IMG_AWAY + " INTEGER" + ")";
        db.execSQL(createTable);

        String insertSQL = "INSERT INTO " + TABLE_NAME +
                " (date, homeTeam, awayTeam, time, winHome, draw, winAway, oddHome, oddDraw, oddAway, imgHome, imgAway" +
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        // 1. Tottenham vs Manchester United
        db.execSQL(insertSQL, new Object[]{
                "2025-11-08", "Tottenham", "Manchester United", "07:30 PM",
                36, 11, 53, 2.595, 3.92, 2.667, R.drawable.tottenham, R.drawable.mu
        });

        // 2. Everton vs Fulham
        db.execSQL(insertSQL, new Object[]{
                "2025-11-08", "Everton", "Fulham", "10:00 PM",
                49, 21, 30, 2.247, 3.49, 3.715, R.drawable.everton, R.drawable.fulham
        });

        // 3. West Ham vs Burnley
        db.execSQL(insertSQL, new Object[]{
                "2025-11-08", "West Ham", "Burnley", "10:00 PM",
                58, 15, 27, 2.094, 3.715, 3.715, R.drawable.west_ham, R.drawable.burnley
        });

        // 4. Sunderland vs Arsenal
        db.execSQL(insertSQL, new Object[]{
                "2025-11-09", "Sunderland", "Arsenal", "12:30 AM",
                44, 11, 45, 7.95, 4.74, 1.473, R.drawable.sunderland, R.drawable.arsenal
        });

        // 5. Chelsea vs Wolverhampton
        db.execSQL(insertSQL, new Object[]{
                "2025-11-09", "Chelsea", "Wolverhampton", "03:00 AM",
                40, 10, 50, 1.388, 5.41, 9.05, R.drawable.chelsea, R.drawable.wolver
        });

        // 6. Aston Villa vs AFC Bournemouth
        db.execSQL(insertSQL, new Object[]{
                "2025-11-09", "Aston Villa", "AFC Bournemouth", "09:00 PM",
                37, 21, 42, 2.237, 3.655, 3.39, R.drawable.aston_villa, R.drawable.bournemouth
        });

        // 7. Brentford vs Newcastle United
        db.execSQL(insertSQL, new Object[]{
                "2025-11-09", "Brentford", "Newcastle United", "09:00 PM",
                58, 21, 21, 3.145, 3.655, 2.359, R.drawable.brentford, R.drawable.newcastle
        });

        // 8. Crystal Palace vs Brighton
        db.execSQL(insertSQL, new Object[]{
                "2025-11-09", "Crystal Palace", "Brighton", "09:00 PM",
                50, 26, 24, 2.319, 3.725, 3.165, R.drawable.crystal_palace, R.drawable.brighton
        });

        // 9. Nottingham Forest vs Leeds United
        db.execSQL(insertSQL, new Object[]{
                "2025-11-09", "Nottingham Forest", "Leeds United", "09:00 PM",
                36, 19, 45, 2.358, 3.315, 3.315, R.drawable.nottingham, R.drawable.leeds
        });

        // 10. Manchester City vs Liverpool
        db.execSQL(insertSQL, new Object[]{
                "2025-11-09", "Manchester City", "Liverpool", "11:30 PM",
                55, 25, 20, 2.001, 4.06, 3.675, R.drawable.mc, R.drawable.liverpool
        });

        // 11. Burnley vs Chelsea
        db.execSQL(insertSQL, new Object[]{
                "2025-11-22", "Burnley", "Chelsea", "07:30 PM",
                48, 24, 28, 3.145, 3.655, 2.359, R.drawable.burnley, R.drawable.chelsea
        });

        // 12. AFC Bournemouth vs West Ham
        db.execSQL(insertSQL, new Object[]{
                "2025-11-22", "AFC Bournemouth", "West Ham", "10:00 PM",
                52, 24, 24, 2.358, 3.45, 3.315, R.drawable.bournemouth, R.drawable.west_ham
        });

        // 13. Brighton vs Brentford
        db.execSQL(insertSQL, new Object[]{
                "2025-11-22", "Brighton", "Brentford", "10:00 PM",
                40, 28, 32, 3.145, 3.655, 2.359, R.drawable.brighton, R.drawable.brentford
        });

        // 14. Fulham vs Sunderland
        db.execSQL(insertSQL, new Object[]{
                "2025-11-22", "Fulham", "Sunderland", "10:00 PM",
                40, 21, 39, 3.145, 3.655, 2.359, R.drawable.fulham, R.drawable.sunderland
        });

        // 15. Liverpool vs Nottingham Forest
        db.execSQL(insertSQL, new Object[]{
                "2025-11-22", "Liverpool", "Nottingham Forest", "10:00 PM",
                53, 29, 18, 2.001, 4.06, 3.675, R.drawable.liverpool, R.drawable.nottingham
        });

        // 16. Wolverhampton vs Crystal Palace
        db.execSQL(insertSQL, new Object[]{
                "2025-11-22", "Wolverhampton", "Crystal Palace", "10:00 PM",
                50, 12, 38, 6.95, 4.74, 1.473, R.drawable.wolver, R.drawable.crystal_palace
        });

        // 17. Newcastle City vs Manchester City
        db.execSQL(insertSQL, new Object[]{
                "2025-11-22", "Newcastle City", "Manchester City", "12:30 AM",
                33, 14, 53, 2.595, 3.92, 2.667, R.drawable.newcastle, R.drawable.mc
        });

        // 18. Leeds United vs Aston Villa
        db.execSQL(insertSQL, new Object[]{
                "2025-11-23", "Leeds United", "Aston Villa", "09:00 PM",
                37, 28, 35, 3.145, 3.655, 2.359, R.drawable.leeds, R.drawable.aston_villa
        });

        // 19. Arsenal vs Tottenham
        db.execSQL(insertSQL, new Object[]{
                "2025-11-23", "Arsenal", "Tottenham", "11:30 PM",
                53, 16, 31, 2.595, 3.92, 2.667, R.drawable.arsenal, R.drawable.tottenham
        });

        // 20. Manchester United vs Everton
        db.execSQL(insertSQL, new Object[]{
                "2025-11-24", "Manchester United", "Everton", "03:00 AM",
                32, 18, 50, 1.388, 5.41, 9.05, R.drawable.mu, R.drawable.everton
        });
    }

    public Cursor getAllMatches() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        return getReadableDatabase().rawQuery(sql, null);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
