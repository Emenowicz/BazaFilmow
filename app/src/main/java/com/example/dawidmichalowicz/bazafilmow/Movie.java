package com.example.dawidmichalowicz.bazafilmow;

/**
 * Created by Dawid Michałowicz on 19.04.2017.
 */

public class Movie {
    private String title, genre, year, description;
    private float rating = 0;
    private boolean toWatch = false;

    public Movie(String title, String genre, String year, String description) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public boolean isToWatch() {
        return toWatch;
    }

    public void setToWatch(boolean toWatch) {
        this.toWatch = toWatch;
    }
}
