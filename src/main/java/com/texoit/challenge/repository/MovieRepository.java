package com.texoit.challenge.repository;

import com.texoit.challenge.domain.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface MovieRepository extends CrudRepository<Movie,Long> {

    List<Movie> findByWinner(Boolean winner);

    List<Movie> findAll();

}
