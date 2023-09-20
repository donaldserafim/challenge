package com.texoit.challenge.service;

import com.texoit.challenge.domain.Movie;
import java.util.List;

public interface LoadMovieService {
    List<Movie> readMovieFromFile(String file);
}
