package com.texoit.challenge.service;

import com.texoit.challenge.domain.Movie;

import java.util.List;

public interface MovieService {
    Movie save(Movie movie);
    List<Movie> findByWinner();

    List<Movie> findAll();
}
