package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    public String addMovie(Movie movie){
        String ans=movieRepository.addMovie(movie);
        return ans;
    }

    public String addDirector(Director director){
        String ans=movieRepository.addDirector(director);
        return ans;
    }
    public String pairMoieDirector(String movieName,String directorName){
        String ans=movieRepository.pairMoieDirector(movieName,directorName);
        return ans;
    }
    public Movie getMovieByName(String movieName){
        Movie ans=movieRepository.getMovieByName(movieName);
        return ans;
    }
    public Director getDirectorByName(String directorName){
        Director ans=movieRepository.getDirectorByName(directorName);
        return ans;
    }
    public List<String> getMoviesByDirectorName(String directorName){
        List<String> movieList=movieRepository.getMoviesByDirectorName(directorName);
        return movieList;
    }

    public String deleteDirectorByName(String directorName){
        String ans=movieRepository.deleteDirectorByName(directorName);
        return ans;
    }
    public String deleteAllDirectors(){
        String ans=movieRepository.deleteAllDirectors();
        return ans;
    }
    public List<String> findAllMovies(){
        List<String> moviesList=movieRepository.findAllMovies();
        return moviesList;
    }
}
