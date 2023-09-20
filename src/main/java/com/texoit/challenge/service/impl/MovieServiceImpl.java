package com.texoit.challenge.service.impl;

import com.texoit.challenge.domain.Movie;
import com.texoit.challenge.repository.MovieRepository;
import com.texoit.challenge.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> findByWinner() {
        return movieRepository.findByWinner(true);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }


}
