package com.example.dawidmichalowicz.bazafilmow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

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
    @BindString(R.string.image)
    String image;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_profile);
        ButterKnife.bind(this);
        setData();
        Bundle bundle = new Bundle();
        //HERE;
    }

    private void setData() {
        titleTV.setText(getIntent().getStringExtra(title));
        genreTV.setText(getIntent().getStringExtra(genre));
        descriptionTV.setText(getIntent().getStringExtra(description));
        movieImage.setImageResource(Utils.chooseImage((String) genreTV.getText()));
        ratingBar.setRating(getIntent().getFloatExtra(rating, 0.0f));
    }

    @Override
    public void onBackPressed() {
        Intent resIntent = new Intent();
        resIntent.putExtra(position, getIntent().getIntExtra(position, 0));
        resIntent.putExtra(rating, ratingBar.getRating());
        setResult(RESULT_OK, resIntent);
        finish();
    }
}