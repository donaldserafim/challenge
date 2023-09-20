package com.texoit.challenge.controller;

import com.texoit.challenge.domain.Movie;
import com.texoit.challenge.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getMovies(){
        return movieService.findAll();
    }

    @PostMapping
    public Movie save(@RequestBody Movie movie){
        return movieService.save(movie);
    }
}
