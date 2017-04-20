package com.example.dawidmichalowicz.bazafilmow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;


import java.util.ArrayList;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Dawid Michałowicz on 19.04.2017.
 */

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindString(R.string.rating)
    String rating;
    @BindString(R.string.position)
    String position;
    @BindString(R.string.movies)
    String movies;

    private ArrayList<Movie> movieList = new ArrayList<>();
    private MoviesAdapter moviesAdapter = new MoviesAdapter(movieList,this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (savedInstanceState != null) {
            movieList = savedInstanceState.getParcelableArrayList(movies);
            moviesAdapter.notifyDataSetChanged();
        } else {
            prepareMovieData();
        }
        setRecyclerView();
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(setSimpleItemTouchCallback());
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        moviesAdapter.setItemRating(data.getIntExtra(position, 0), data.getFloatExtra(rating, 0.0f));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(movies, movieList);
        super.onSaveInstanceState(outState);
    }

    private ItemTouchHelper.SimpleCallback setSimpleItemTouchCallback() {
        return new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                moviesAdapter.removeItem(viewHolder.getAdapterPosition());
            }
        };
    }

    private void setRecyclerView() {
        moviesAdapter = new MoviesAdapter(movieList, MainActivity.this);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(moviesAdapter);
    }


    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road", "Action", "2015", "Max przyłącza się do grupy uciekinierek z Cytadeli - osady rządzonej przez Wiecznego Joe. Tyran wraz ze swoją bandą rusza za nimi w pościg.");
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation", "2015", "Życiem Riley kieruje pięć emocji: Radość, Strach, Gniew, Odraza i Smutek. Pozostałe próbują zakłócić pierwszą, gdy dziewczyna przeprowadza się z rodzicami do San Francisco. ");
        movieList.add(movie);

        movie = new Movie("Star Wars: The Force Awakens", "Action", "2015", "Złe Imperium zostaje zastąpione przez Najwyższy Porządek, który chce władzy nad galaktyką. Plany wrogiej organizacji może pokrzyżować Ruch Oporu.");
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015", "Baranek Shaun wyrusza w pełną niebezpieczeństw i przygód wyprawę do miasta, aby ratować z tarapatów gospodarza swojej farmy. ");
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction", "2015", "Po nieudanej ekspedycji Mark zostaje sam na Marsie. Mimo znikomych zapasów oraz zerwanej łączności z dowództwem mężczyzna stara się przetrwać w trudnych warunkach.");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015", "Agent IMF Ethan Hunt wraz ze swoim ludźmi mierzy się z organizacją Syndykat.");
        movieList.add(movie);

        movie = new Movie("Up", "Animation", "2009", "70-letni Carl po śmierci żony zamienia swój dom w statek powietrzny i odlatuje do Ameryki Południowej, by spełnić swoje marzenie. Przez przypadek zabiera ze sobą ośmioletniego skauta.");
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009", "Początki załogi USS Enterprise. James Kirk i Spock łączą siły, by ocalić swoich przyjaciół przed śmiertelnym niebezpieczeństwem.");
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014", "Emmet, przeciętna minifigurka LEGO, zostaje wzięty za wybranego do ocalenia świata. W ten sposób dołącza do drużyny, która ma powstrzymać złowrogiego tyrana.");
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action", "2008", "Tony Stark buduje supernowoczesną zbroję. Multimiliarder postanawia walczyć ze złem jako Iron Man.");
        movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986", "Ripley razem z oddziałem komandosów wyrusza na pomoc mieszkańcom planety, na której pojawili się obcy. ");
        movieList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000", "Zamknięci, otoczeni drutem kolczastym, drżący o swoje życie Rocky, Ginger, Bunty oraz Fowler podejmują rozpaczliwą próbę ucieczki. I oto po raz pierwszy w historii filmu będziemy mogli śledzić przygody... bohaterskiego drobiu!");
        movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985", "W 1985 roku dr Emmett Brown buduje wehikuł czasu. Jego przyjaciel Marty McFly przenosi się w lata 50. i niechcący przeszkadza w poznaniu się swoim rodzicom.");
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action", "1981", "Indiana Jones wyrusza do Egiptu, gdzie prawdopodobnie odkryto miejsce przechowywania Arki Przymierza. Nie może dopuścić, by trofeum znalazło się w rękach nazistów.");
        movieList.add(movie);

        movie = new Movie("Goldfinger", "Action", "1965", "Agent 007 mierzy się z multimilionerem Aurikiem Goldfingerem, który chce obrabować Fort Knox.");
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction", "2014", "Zuchwały awanturnik Peter Quill kradnie tajemniczy artefakt będący obiektem pożądania złego i potężnego Ronana, którego ambicje zagrażają całemu wszechświatowi.");
        movieList.add(movie);

        if(moviesAdapter!=null) {
            moviesAdapter.notifyDataSetChanged();
        }
    }


}
