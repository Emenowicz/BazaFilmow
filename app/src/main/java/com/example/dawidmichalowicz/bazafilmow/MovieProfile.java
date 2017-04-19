package com.example.dawidmichalowicz.bazafilmow;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.dawidmichalowicz.bazafilmow.R.string.genre;
import static com.example.dawidmichalowicz.bazafilmow.R.string.year;

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
    @BindView(R.id.genreTV)
    TextView genreTV;
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;
    @BindString(R.string.title)
    String title;
    @BindString(R.string.genre)
    String genre;
    @BindString(R.string.description)
    String description;
    @BindString(R.string.rating)
    String rating;


    Intent intent;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = getIntent();
        setContentView(R.layout.movie_profile);
        ButterKnife.bind(this);

    }

    private void setData() {
        titleTV.setText(intent.getStringExtra(title));
        genreTV.setText(intent.getStringExtra(genre));
        descriptionTV.setText(intent.getStringExtra(description));
        ratingBar.setRating(getIntent().getFloatExtra(rating, 0.f));
    }

    @Override
    public void onBackPressed() {
        Intent resIntent = new Intent();
        resIntent.putExtra("position", intent.getIntExtra("position", 0));
        resIntent.putExtra("rating", ratingBar.getRating());
        setResult(RESULT_OK, resIntent);
        finish();
    }
}