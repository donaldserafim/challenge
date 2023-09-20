package com.texoit.challenge.service.impl;

import com.texoit.challenge.dto.Award;
import com.texoit.challenge.dto.Winner;
import com.texoit.challenge.domain.Movie;
import com.texoit.challenge.service.AwardsManagerService;
import com.texoit.challenge.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AwardsManagerServiceImpl implements AwardsManagerService {

    @Autowired
    MovieService movieService;

    @Override
    public Award getWinners() {
        Award award = new Award();
        award.setMax(Arrays.asList(getProducerWithLongestGap(movieService.findByWinner())));
        award.setMin(Arrays.asList(getProducerWithFastestTwoAwards(movieService.findByWinner())));
        return award;
    }
    private Winner getProducerWithLongestGap(List<Movie> movies){
        List<Winner> winners = new ArrayList<>();

        Map<String, List<Movie>> moviesGroups = getGroupMoviesFromProducer(movies);

        for (Map.Entry<String, List<Movie>> movieGroup : moviesGroups.entrySet()) {
            if(movieGroup.getValue().size() < 2){
                continue;
            }

            int intervalMovieGroup = Integer.MIN_VALUE;
            Winner winner = new Winner();
            movieGroup.getValue().sort(Comparator.comparing(Movie::getYear));

            for (int i = 1; i < movieGroup.getValue().size(); i++) {
                Movie movieActual = movieGroup.getValue().get(i);
                Movie movieLast = movieGroup.getValue().get(i - 1);
                int interval = movieActual.getYear() - movieLast.getYear();

                if(interval > intervalMovieGroup){
                    winner.setPreviousWin(movieLast.getYear());
                    winner.setFollowingWin(movieActual.getYear());
                    winner.setInterval(interval);
                    winner.setProducer(movieGroup.getKey());
                    intervalMovieGroup = interval;
                }
            }
            winners.add(winner);
        }

        return  Collections.max(winners, Comparator.comparing(c -> c.getInterval()));
    }

    private Winner getProducerWithFastestTwoAwards(List<Movie> movies){
        List<Winner> winners = new ArrayList<>();

        Map<String, List<Movie>> moviesGroups = getGroupMoviesFromProducer(movies);

        for (Map.Entry<String, List<Movie>> movieGroup : moviesGroups.entrySet()) {
            if(movieGroup.getValue().size() <2){
                continue;
            }

            int intervalMovieGroup = Integer.MAX_VALUE;
            Winner winner = new Winner();
            movieGroup.getValue().sort(Comparator.comparing(Movie::getYear));

            for (int i = 1; i < movieGroup.getValue().size(); i++) {
                Movie movieActual = movieGroup.getValue().get(i);
                Movie movieLast = movieGroup.getValue().get(i - 1);
                int interval = movieActual.getYear() - movieLast.getYear();

                if(interval < intervalMovieGroup){
                    winner.setPreviousWin(movieLast.getYear());
                    winner.setFollowingWin(movieActual.getYear());
                    winner.setProducer(movieGroup.getKey());
                    winner.setInterval(interval);
                    intervalMovieGroup = interval;
                }
            }
            winners.add(winner);
        }
        return  Collections.min(winners, Comparator.comparing(c -> c.getInterval()));
    }

    private Map<String, List<Movie>> getGroupMoviesFromProducer(List<Movie> movies) {
        Map<String, List<Movie>> moviesGroups = new HashMap<String, List<Movie>>();
        for (Movie movie: movies){
            for(String producer: movie.getProducers()){
                if (!moviesGroups.containsKey(producer)) {
                    moviesGroups.put(producer, new ArrayList<>());
                }
                moviesGroups.get(producer).add(movie);
            }
        }
        return moviesGroups;
    }
}
