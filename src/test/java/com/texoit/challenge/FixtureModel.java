package com.texoit.challenge;

import com.texoit.challenge.domain.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FixtureModel {

    public static List<Movie> buildMoveis(){
        List<Movie> movies = new ArrayList<>();

        Movie movie = new Movie();
        movie.setYear(1950);
        movie.setTitle("O vento levou");
        movie.setId(1L);
        movie.setProducers(Arrays.asList("Donald","Willians"));
        movie.setStudios(Arrays.asList("Donald","Willians"));
        movie.setWinner(true);
        movies.add(movie);

        Movie movie2 = new Movie();
        movie2.setYear(1901);
        movie2.setTitle("O vento levou");
        movie2.setId(1L);
        movie2.setProducers(Arrays.asList("Donald","Willians"));
        movie2.setStudios(Arrays.asList("Donald","Willians"));
        movie2.setWinner(true);
        movies.add(movie2);

        Movie movie3 = new Movie();
        movie3.setYear(1905);
        movie3.setTitle("O vento levou");
        movie3.setId(1L);
        movie3.setProducers(Arrays.asList("Donald","Willians"));
        movie3.setStudios(Arrays.asList("Donald","Willians"));
        movie3.setWinner(true);
        movies.add(movie3);

        Movie movie4 = new Movie();
        movie4.setYear(1910);
        movie4.setTitle("O vento levou");
        movie4.setId(1L);
        movie4.setProducers(Arrays.asList("Donald","Willians"));
        movie4.setStudios(Arrays.asList("Donald","Willians"));
        movie4.setWinner(true);
        movies.add(movie4);

        Movie movie5 = new Movie();
        movie5.setYear(1902);
        movie5.setTitle("O vento levou");
        movie5.setId(1L);
        movie5.setProducers(Arrays.asList("Donald"));
        movie5.setStudios(Arrays.asList("Donald","Willians"));
        movie5.setWinner(true);
        movies.add(movie5);

        Movie movie6 = new Movie();
        movie6.setYear(1960);
        movie6.setTitle("O vento levou");
        movie6.setId(1L);
        movie6.setProducers(Arrays.asList("Donald"));
        movie6.setStudios(Arrays.asList("Donald","Willians"));
        movie6.setWinner(true);
        movies.add(movie6);

        return movies;
    }
}
