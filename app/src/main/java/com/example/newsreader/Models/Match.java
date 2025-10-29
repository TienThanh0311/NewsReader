package com.example.newsreader.Models;

public class Match {
    private String date;
    private String homeTeam;
    private String awayTeam;
    private String time;
    private int winHome;
    private int draw;
    private int winAway;
    private double oddHome;
    private double oddDraw;
    private double oddAway;
    private int imgHome;
    private int imgAway;


    public Match(String date, String homeTeam, String awayTeam, String time, int winHome, int draw, int winAway, double oddHome, double oddDraw, double oddAway,int imgHome, int imgAway) {
        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.time = time;
        this.winHome = winHome;
        this.draw = draw;
        this.winAway = winAway;
        this.oddHome = oddHome;
        this.oddDraw = oddDraw;
        this.oddAway = oddAway;
        this.imgHome = imgHome;
        this.imgAway = imgAway;
    }
    public int getImgHome() {
        return imgHome;
    }
    public void setImgHome(int imgHome) {
        this.imgHome = imgHome;
    }

    public int getImgAway() {
        return imgAway;
    }

    public void setImgAway(int imgAway) {
        this.imgAway = imgAway;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getHomeTeam() {
        return homeTeam;
    }
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }
    public String getAwayTeam() {
        return awayTeam;
    }
    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getWinHome() {
        return winHome;
    }

    public void setWinHome(int winHome) {
        this.winHome = winHome;
    }
    public int getDraw() {
        return draw;
    }
    public void setDraw(int draw) {
        this.draw = draw;
    }
    public int getWinAway() {
        return winAway;
    }

    public void setWinAway(int winAway) {
        this.winAway = winAway;
    }
    public double getOddHome() {
        return oddHome;
    }

    public void setOddHome(double oddHome) {
        this.oddHome = oddHome;
    }


    public double getOddDraw() {
        return oddDraw;
    }

    public void setOddDraw(double oddDraw) {
        this.oddDraw = oddDraw;
    }

    public double getOddAway() {
        return oddAway;
    }

    public void setOddAway(double oddAway) {
        this.oddAway = oddAway;
    }

}
