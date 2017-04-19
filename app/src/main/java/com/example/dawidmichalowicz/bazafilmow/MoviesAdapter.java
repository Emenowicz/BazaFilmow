package com.example.dawidmichalowicz.bazafilmow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Dawid Michałowicz on 19.04.2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Movie> moviesList;
    private Context context;

    public MoviesAdapter(List<Movie> moviesList, Context context) {
        this.moviesList = moviesList;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }


    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        if (viewType == 0) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row, parent, false);
        } else {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row_rev, parent, false);
        }
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        Movie movie = moviesList.get(position);
        MyViewHolder myHolder = (MyViewHolder) holder;
        myHolder.title.setText(movie.getTitle());
        myHolder.genre.setText(movie.getGenre());
        myHolder.year.setText(movie.getYear());
        if (movie.isToWatch()) {
            myHolder.eyeImage.setVisibility(View.VISIBLE);
        } else {
            myHolder.eyeImage.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    void removeItem(int position) {
        moviesList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, getItemCount());
    }

    void setItemRating(int position, float rating){
        moviesList.get(position).setRating(rating);
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView title, year, genre;
        ImageView eyeImage, movieImage;

        MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.movie_title);
            genre = (TextView) view.findViewById(R.id.movie_genre);
            year = (TextView) view.findViewById(R.id.movie_year);
            movieImage = (ImageView) view.findViewById(R.id.movie_image);
            eyeImage = (ImageView) view.findViewById(R.id.eyeImageView);
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
        }


        @Override
        public void onClick(View v) {
            Intent it = new Intent(context, MovieProfile.class);
            it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            it.putExtra(context.getString(R.string.title),title.getText().toString());
            it.putExtra(context.getString(R.string.genre),genre.getText().toString());
            it.putExtra(context.getString(R.string.year),year.getText().toString());
            it.putExtra(context.getString(R.string.image),Integer.parseInt(movieImage.getTag().toString()));
            it.putExtra(context.getString(R.string.rating),moviesList.get(getAdapterPosition()).getRating());
            it.putExtra(context.getString(R.string.position),getAdapterPosition());
            ((Activity) context).startActivityForResult(it,1);
        }

        @Override
        public boolean onLongClick(View v) {
            if (moviesList.get(getAdapterPosition()).isToWatch()) {
                moviesList.get(getAdapterPosition()).setToWatch(false);
            } else {
                moviesList.get(getAdapterPosition()).setToWatch(true);
            }
            notifyDataSetChanged();
            return true;
        }
    }


}
