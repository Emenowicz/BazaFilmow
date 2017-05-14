package com.example.dawidmichalowicz.bazafilmow;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindString;
import butterknife.ButterKnife;

/**
 * Created by Dawid Michałowicz on 14.05.2017.
 */

public class MovieContainer extends AppCompatActivity {
    @BindString(R.string.title)
    String title;
    @BindString(R.string.genre)
    String genre;
    @BindString(R.string.image)
    String image;
    @BindString(R.string.rating)
    String rating;
    @BindString(R.string.position)
    String position;
    @BindString(R.string.description)
    String description;
    MovieFragment movieFragment;
    String actualPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_profile_container);
        ButterKnife.bind(this);
        if (savedInstanceState != null) {
            actualPage = savedInstanceState.getString("State");
        }
        Bundle bundle = new Bundle();
        bundle.putString(title, getIntent().getExtras().getString(title));
        bundle.putString(description, getIntent().getExtras().getString(description));
        bundle.putString(genre, getIntent().getExtras().getString(genre));
        bundle.putString(title, getIntent().getExtras().getString(title));
        bundle.putFloat(rating, getIntent().getFloatExtra(rating, 0.0f));
        movieFragment = new MovieFragment();
        movieFragment.setArguments(bundle);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (savedInstanceState.get("State").equals("movieFragment")) {
            fragmentTransaction.add(R.id.fragment_container, movieFragment);
        }
        fragmentTransaction.add(R.id.fragment_container, movieFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        Intent resIntent = new Intent();
        resIntent.putExtra(position, getIntent().getIntExtra(position, 0));
        resIntent.putExtra(rating, movieFragment.getRating());
        setResult(RESULT_OK, resIntent);
        finish();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("Page", actualPage);
    }

}
