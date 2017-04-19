package com.example.dawidmichalowicz.bazafilmow;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Dawid Michałowicz on 19.04.2017.
 */

public class Movie implements Parcelable {
    private String title, genre, year, description;
    private float rating = 0;
    private boolean toWatch = false;

    public Movie(String title, String genre, String year, String description) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.description = description;
    }

    protected Movie(Parcel in) {
        title = in.readString();
        genre = in.readString();
        year = in.readString();
        description = in.readString();
        rating = in.readFloat();
        toWatch = in.readByte() != 0;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

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

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(genre);
        dest.writeString(year);
        dest.writeString(description);
        dest.writeFloat(rating);
        dest.writeByte((byte) (toWatch ? 1 : 0));
    }
}
