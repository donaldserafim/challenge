package com.texoit.challenge.service;


import com.texoit.challenge.FixtureModel;
import com.texoit.challenge.dto.Award;
import com.texoit.challenge.repository.MovieRepository;
import com.texoit.challenge.service.impl.AwardsManagerServiceImpl;
import com.texoit.challenge.service.impl.LoadMovieServiceImpl;
import com.texoit.challenge.service.impl.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AwardsManagerImplTest {

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private MovieServiceImpl movieService;

    @InjectMocks
    private AwardsManagerServiceImpl awardsManager;

    @InjectMocks
    private LoadMovieServiceImpl loadMovieService;

    @Test
    public void getMoviesAndReturnAward(){
        when(movieService.findByWinner()).thenReturn(FixtureModel.buildMoveis());
        Award award = awardsManager.getWinners();
        assertEquals(award.getMax().get(0).getInterval(),40);
        assertEquals(award.getMin().get(0).getInterval(),1);
    }

    @Test
    public void readFileAndReturnMovies(){
        when(movieService.findByWinner()).thenReturn(loadMovieService.readMovieFromFile("data/movielist_winners.csv"));
        Award award = awardsManager.getWinners();
        assertEquals(award.getMax().get(0).getInterval(),13);
        assertEquals(award.getMin().get(0).getInterval(),1);
    }

    @Test
    public void readFileAndAddMoreMoviesAndReturnMovies(){
        when(movieService.findByWinner()).thenReturn(loadMovieService.readMovieFromFile("data/movielist_winners_add_more.csv"));
        Award award = awardsManager.getWinners();
        assertEquals(award.getMax().get(0).getInterval(),22);
        assertEquals(award.getMin().get(0).getInterval(),1);
    }

    @Test
    public void readFileAndReturnMoviesWrong(){
        when(movieService.findByWinner()).thenReturn(loadMovieService.readMovieFromFile("data/movielist_winners_wrong.csv"));
        Award award = awardsManager.getWinners();
        assertNotEquals(award.getMax().get(0).getInterval(),13);
        assertNotEquals(award.getMin().get(0).getInterval(),1);
    }
}
