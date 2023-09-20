package com.texoit.challenge;

import com.texoit.challenge.service.LoadMovieService;
import com.texoit.challenge.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ChallengeApplication {

	@Value("${path.and.file.from.resources}")
	String file;

	@Autowired
	MovieService movieService;

	@Autowired
	LoadMovieService loadMovieService;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void readFileAndSaveMovies() {
		loadMovieService.readMovieFromFile(file).forEach(movie ->
				movieService.save(movie)
		);
	}
}