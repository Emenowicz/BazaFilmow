package com.example.dawidmichalowicz.bazafilmow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dawid Michałowicz on 19.04.2017.
 */

public class MovieProfile extends AppCompatActivity {
    @BindView(R.id.movie_image)
    ImageView movieImage;
    @BindView(R.id.movie_title)
    TextView titleTV;
    @BindView(R.id.description)
    TextView descriptionTV;
    @BindView(R.id.movie_genre)
    TextView genreTV;
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;
    @BindString(R.string.title)
    String title;
    @BindString(R.string.genre)
    String genre;
    @BindString(R.string.year)
    String year;
    @BindString(R.string.description)
    String description;
    @BindString(R.string.rating)
    String rating;
    @BindString(R.string.position)
    String position;
//
//    @BindView(R.id.movie_title) TextView titleDesc;
//    @BindView(R.id.movie_image) ImageView imageViewDesc;
//    @BindView(R.id.description) TextView textDesc;
//    @BindView(R.id.ratingBar) RatingBar ratingBar;
//    @BindString(R.string.title) String title;
//    @BindString(R.string.year) String year;
//    @BindString(R.string.genre) String genre;
//    @BindString(R.string.image) String img;
//    @BindString(R.string.rating) String rating;
//    @BindString(R.string.position) String position;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_profile);
        ButterKnife.bind(this);
        setData();
    }

    private void setData() {
        titleTV.setText(getIntent().getStringExtra(title));
        genreTV.setText(getIntent().getStringExtra(genre));
        descriptionTV.setText(getIntent().getStringExtra(description));
        ratingBar.setRating(getIntent().getFloatExtra(rating, 0.0f));
        Toast.makeText(this,String.valueOf(getIntent().getFloatExtra(rating,0.0f)),Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onBackPressed() {
        Intent resIntent = new Intent();
        resIntent.putExtra(position, getIntent().getIntExtra(position, 0));
        resIntent.putExtra(rating, ratingBar.getRating());
        Toast.makeText(this,"rating:" + ratingBar.getRating(),Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK, resIntent);
        finish();
    }
}