package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    HashMap<String,Movie> movieDb=new HashMap<>();
    HashMap<String,Director> directorDb=new HashMap<>();
    HashMap<String,List<String>> movieDirectorPair=new HashMap<>();

    public String addMovie(Movie movie){
        String key=movie.getName();
        movieDb.put(key,movie);
        return "Movie added successfully";
    }
    public String addDirector(Director director){
        String key=director.getName();
        directorDb.put(key,director);
        return "Director added successfully";
    }
    public String pairMoieDirector(String movieName,String directorName){
        List<String> movies=new ArrayList<>();
        if(!movieDirectorPair.containsKey(directorName)){

        }
        else{
            movies=movieDirectorPair.get(directorName);
        }
        movies.add(movieName);
        movieDirectorPair.put(directorName,movies);
        return "connected them successfully";
    }
    public Movie getMovieByName(String movieName){
        return movieDb.get(movieName);
    }
    public Director getDirectorByName(String directorName){
        return directorDb.get(directorName);
    }
    public List<String> getMoviesByDirectorName(String directorName){
        List<String> movieList=new ArrayList<>();
        movieList=movieDirectorPair.get(directorName);
        return movieList;
    }
    public String deleteDirectorByName(String directorName){
        //director db delete

        // delete movies by him

        // delete director movies db

        directorDb.remove(directorName);
        List<String> movies=movieDirectorPair.get(directorName);
        for(String movie:movies){
            movieDb.remove(movie);
        }
        movieDirectorPair.remove(directorName);
        return "Director removed successfully";
    }
    public String deleteAllDirectors(){
        directorDb=new HashMap<>();
        for(String directorName:movieDirectorPair.keySet()){
            List<String> movies=movieDirectorPair.get(directorName);
            for(String movie:movies){
                movieDb.remove(movie);
            }
            movieDirectorPair.remove(directorName);
        }
        return "All directors deleted";
    }

    public List<String>findAllMovies(){
        List<String> movieList=new ArrayList<>();
        for(Movie movie:movieDb.values()){
            movieList.add(movie.getName());
        }
        return movieList;
    }
}