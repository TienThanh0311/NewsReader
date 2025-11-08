package com.example.newsreader;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBMatchContext extends SQLiteOpenHelper {
    private static final String DB_NAME = "EPLSchedule.db";


    private static final int DB_VERSION = 3;

    private static final String TABLE_NAME = "football_matches";

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
                + COL_MATCH_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
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


        // --- VÒNG 12 ---

        // 1. Burnley vs Chelsea (Vòng 12)
        db.execSQL(insertSQL, new Object[]{
                "2025-11-22", "Burnley", "Chelsea", "07:30 PM",
                48, 24, 28, 3.145, 3.655, 2.359, R.drawable.burnley, R.drawable.chelsea
        });

        // 2. AFC Bournemouth vs West Ham (Vòng 12)
        db.execSQL(insertSQL, new Object[]{
                "2025-11-22", "AFC Bournemouth", "West Ham", "10:00 PM",
                52, 24, 24, 2.358, 3.45, 3.315, R.drawable.bournemouth, R.drawable.west_ham
        });

        // 3. Brighton vs Brentford (Vòng 12)
        db.execSQL(insertSQL, new Object[]{
                "2025-11-22", "Brighton", "Brentford", "10:00 PM",
                40, 28, 32, 3.145, 3.655, 2.359, R.drawable.brighton, R.drawable.brentford
        });

        // 4. Fulham vs Sunderland (Vòng 12)
        db.execSQL(insertSQL, new Object[]{
                "2025-11-22", "Fulham", "Sunderland", "10:00 PM",
                40, 21, 39, 3.145, 3.655, 2.359, R.drawable.fulham, R.drawable.sunderland
        });

        // 5. Liverpool vs Nottingham Forest (Vòng 12)
        db.execSQL(insertSQL, new Object[]{
                "2025-11-22", "Liverpool", "Nottingham Forest", "10:00 PM",
                53, 29, 18, 2.001, 4.06, 3.675, R.drawable.liverpool, R.drawable.nottingham
        });

        // 6. Wolverhampton vs Crystal Palace (Vòng 12)
        db.execSQL(insertSQL, new Object[]{
                "2025-11-22", "Wolverhampton", "Crystal Palace", "10:00 PM",
                50, 12, 38, 6.95, 4.74, 1.473, R.drawable.wolver, R.drawable.crystal_palace
        });

        // 7. Newcastle City vs Manchester City (Vòng 12)
        db.execSQL(insertSQL, new Object[]{
                "2025-11-22", "Newcastle City", "Manchester City", "12:30 AM",
                33, 14, 53, 2.595, 3.92, 2.667, R.drawable.newcastle, R.drawable.mc
        });

        // 8. Leeds United vs Aston Villa (Vòng 12)
        db.execSQL(insertSQL, new Object[]{
                "2025-11-23", "Leeds United", "Aston Villa", "09:00 PM",
                37, 28, 35, 3.145, 3.655, 2.359, R.drawable.leeds, R.drawable.aston_villa
        });

        // 9. Arsenal vs Tottenham (Vòng 12)
        db.execSQL(insertSQL, new Object[]{
                "2025-11-23", "Arsenal", "Tottenham", "11:30 PM",
                53, 16, 31, 2.595, 3.92, 2.667, R.drawable.arsenal, R.drawable.tottenham
        });

        // 10. Manchester United vs Everton (Vòng 12)
        db.execSQL(insertSQL, new Object[]{
                "2025-11-24", "Manchester United", "Everton", "03:00 AM",
                32, 18, 50, 1.388, 5.41, 9.05, R.drawable.mu, R.drawable.everton
        });

        // --- VÒNG 13 ---

        // 11. Brentford vs Burnley (Vòng 13)
        db.execSQL(insertSQL, new Object[]{
                "2025-11-29", "Brentford", "Burnley", "22:00 PM",
                50, 25, 25, 2.5, 3.5, 3.0, R.drawable.brentford, R.drawable.burnley
        });

// 12. Sunderland vs Bournemouth (Vòng 13)
        db.execSQL(insertSQL, new Object[]{
                "2025-11-29", "Sunderland", "AFC Bournemouth", "22:00 PM",
                50, 25, 25, 2.5, 3.5, 3.0, R.drawable.sunderland, R.drawable.bournemouth
        });

// 13. Man City vs Leeds United (Vòng 13)
        db.execSQL(insertSQL, new Object[]{
                "2025-11-29", "Manchester City", "Leeds United", "22:00 PM",
                50, 25, 25, 2.5, 3.5, 3.0, R.drawable.mc, R.drawable.leeds
        });

// 14. Everton vs Newcastle (Vòng 13)
        db.execSQL(insertSQL, new Object[]{
                "2025-11-30", "Everton", "Newcastle United", "00:30 AM",
                50, 25, 25, 2.5, 3.5, 3.0, R.drawable.everton, R.drawable.newcastle
        });

// 15. Tottenham vs Fulham (Vòng 13)
        db.execSQL(insertSQL, new Object[]{
                "2025-11-30", "Tottenham", "Fulham", "03:00 AM",
                50, 25, 25, 2.5, 3.5, 3.0, R.drawable.tottenham, R.drawable.fulham
        });

// 16. Crystal Palace vs Man United (Vòng 13)
        db.execSQL(insertSQL, new Object[]{
                "2025-11-30", "Crystal Palace", "Manchester United", "19:00 PM",
                50, 25, 25, 2.5, 3.5, 3.0, R.drawable.crystal_palace, R.drawable.mu
        });

// 17. West Ham vs Liverpool (Vòng 13)
        db.execSQL(insertSQL, new Object[]{
                "2025-11-30", "West Ham", "Liverpool", "21:05 PM",
                50, 25, 25, 2.5, 3.5, 3.0, R.drawable.west_ham, R.drawable.liverpool
        });

// 18. Aston Villa vs Wolves (Vòng 13)
        db.execSQL(insertSQL, new Object[]{
                "2025-11-30", "Aston Villa", "Wolverhampton", "21:05 PM",
                50, 25, 25, 2.5, 3.5, 3.0, R.drawable.aston_villa, R.drawable.wolver
        });

// 19. Nottm Forest vs Brighton (Vòng 13)
        db.execSQL(insertSQL, new Object[]{
                "2025-11-30", "Nottingham Forest", "Brighton", "21:05 PM",
                50, 25, 25, 2.5, 3.5, 3.0, R.drawable.nottingham, R.drawable.brighton
        });

// 20. Chelsea vs Arsenal (Vòng 13)
        db.execSQL(insertSQL, new Object[]{
                "2025-11-30", "Chelsea", "Arsenal", "23:30 PM",
                50, 25, 25, 2.5, 3.5, 3.0, R.drawable.chelsea, R.drawable.arsenal
        });
    }

    public Cursor getMatchById(int id) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_MATCH_ID + " = ?";
        return getReadableDatabase().rawQuery(sql, new String[]{String.valueOf(id)});
    }

    public Cursor getAllMatches() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        return getReadableDatabase().rawQuery(sql, null);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }
}