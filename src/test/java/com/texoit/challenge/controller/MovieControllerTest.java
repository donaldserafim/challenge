package com.texoit.challenge.controller;

import com.texoit.challenge.FixtureModel;
import com.texoit.challenge.ReadFileUtils;
import com.texoit.challenge.service.LoadMovieService;
import com.texoit.challenge.service.MovieService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MovieController.class)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @MockBean
    private LoadMovieService loadMovieService;

    @Test
    public void shouldReturnMovies() throws Exception {
        when(movieService.findAll()).thenReturn(FixtureModel.buildMoveis());
        mockMvc.perform(get("/movie")).andExpect(status().isOk())
                .andExpect(content().json(ReadFileUtils.readFileAndReturnLines("contracts/list_movies.json")));
    }

    @Test
    public void shouldSaveMovie() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie")
                        .content(ReadFileUtils.readFileAndReturnLines("contracts/save_movie.json"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
