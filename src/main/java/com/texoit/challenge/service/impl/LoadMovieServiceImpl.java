package com.texoit.challenge.service.impl;

import com.texoit.challenge.domain.Movie;
import com.texoit.challenge.service.LoadMovieService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class LoadMovieServiceImpl implements LoadMovieService {

    private static final int YEAR = 0;
    private static final int TITLE = 1;
    private static final int STUDIOS = 2;
    private static final int PRODUCERS = 3;
    private static final int WINNER = 4;
    private static final int HAS_WINNER = 5;
    public static final String YES = "yes";

    @Override
    public List<Movie> readMovieFromFile(String file) {
        return trasformLinesToMovies(readFileAndReturnLines(file));
    }

    private List<String> readFileAndReturnLines(String file) {
        try{
            File resource = new ClassPathResource(
                    file).getFile();
            return Files.readAllLines(resource.toPath());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private List<Movie> trasformLinesToMovies(List<String> lines){
        List<Movie> movies = new ArrayList<>();
        if(!lines.isEmpty()){
            for(String line: lines.subList(1,lines.size())){
                movies.add(transformMoive(line.split(";")));
            }
        }
        return movies;
    }

    private Movie transformMoive(String[] line) {
        Movie movie = new Movie();

        movie.setYear(line[YEAR]!=null?Integer.parseInt(line[YEAR]):0);
        movie.setTitle(line[TITLE]!=null? line[TITLE] :"");
        movie.setProducers(line[PRODUCERS]!=null?Arrays.stream(line[PRODUCERS].split(", ")).toList():Collections.emptyList());
        movie.setStudios(line[STUDIOS]!=null? Arrays.stream(line[STUDIOS].split(", ")).toList(): Collections.emptyList());

        if(line.length == HAS_WINNER){
            movie.setWinner(line[WINNER] != null && YES.equals(line[WINNER]));
        }else{
            movie.setWinner(false);
        }
        return movie;
    }
}
