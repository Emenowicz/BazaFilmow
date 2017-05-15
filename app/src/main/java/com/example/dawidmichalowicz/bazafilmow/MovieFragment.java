package com.example.dawidmichalowicz.bazafilmow;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Dawid Michałowicz on 14.05.2017.
 */

public class MovieFragment extends Fragment {
    RatingBar ratingBar;
    TextView descriptionTV;
    ImageView movieImage;
    TextView titleTV;
    TextView genreTV;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_profile, container, false);
        ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        descriptionTV = (TextView) view.findViewById(R.id.description);
        movieImage = (ImageView) view.findViewById(R.id.movie_image);
        titleTV = (TextView) view.findViewById(R.id.movie_title);
        genreTV = (TextView) view.findViewById(R.id.movie_genre);
        setData();

        movieImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ImageFragment imageFragment = new ImageFragment();
                ActorFragment actorFragment = new ActorFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,imageFragment);
                fragmentTransaction.add(R.id.fragment_container2,actorFragment);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

    private void setData(){
        Bundle bundle = getArguments();
        titleTV.setText(bundle.getString(getResources().getString(R.string.title)));
        descriptionTV.setText(bundle.getString(getResources().getString(R.string.description)));
        genreTV.setText(bundle.getString(getResources().getString(R.string.genre)));
        movieImage.setImageResource(Utils.chooseImage((String) genreTV.getText()));
        ratingBar.setRating(bundle.getFloat(getResources().getString(R.string.rating)));
    }

    public float getRating(){
        return ratingBar.getRating();
    }
}
