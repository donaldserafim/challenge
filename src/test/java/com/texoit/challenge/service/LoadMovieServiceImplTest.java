package com.texoit.challenge.service;

import com.texoit.challenge.service.impl.LoadMovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LoadMovieServiceImplTest {

    @InjectMocks
    private LoadMovieServiceImpl loadMovieService;

    @Test
    public void readFileAndReturnFiveMovies(){
        assertEquals(loadMovieService.readMovieFromFile("data/movielist.csv").size(),45);
    }

    @Test
    public void readEmptyFile(){
        assertEquals(loadMovieService.readMovieFromFile("data/movielist_empty.csv").size(),0);
    }
}
