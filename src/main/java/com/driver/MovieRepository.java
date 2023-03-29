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
    HashMap<String,String> movieDirectorPair=new HashMap<>();

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
        movieDirectorPair.put(movieName,directorName);
        return "connected them successfully";
    }
    public Movie getMovieByName(String movieName){
        return movieDb.get(movieName);
    }
    public Director getDirectorByName(String directorName){
        return directorDb.get(directorName);
    }
    public List<Movie> getMoviesByDirectorName(String directorName){
        List<Movie> movieList=new ArrayList<>();
        for(Map.Entry<String,String> entry:movieDirectorPair.entrySet()){
            if(entry.getValue().equals(directorName)){
                String movieName= entry.getKey();
                Movie movie=movieDb.get(movieName);
                movieList.add(movie);
            }
        }
        return movieList;
    }
    public String deleteDirectorByName(String directorName){
        //director db delete

        // delete movies by him

        // delete director movies db

        directorDb.remove(directorName);
        for(Map.Entry<String,String> entry:movieDirectorPair.entrySet()){
            if(entry.getValue().equals(directorName)){
                String movieName= entry.getKey();
                movieDb.remove(movieName);
                movieDirectorPair.remove(movieName);
            }
        }
        return "Director removed successfully";
    }
    public String deleteAllDirectors(){
        for(Director director:directorDb.values()){
            String directorName=director.getName();

            directorDb.remove(directorName);
            for(Map.Entry<String,String> entry:movieDirectorPair.entrySet()){
                if(entry.getValue().equals(directorName)){
                    String movieName= entry.getKey();
                    movieDb.remove(movieName);
                    movieDirectorPair.remove(movieName);
                }
            }
        }
        return "All directors deleted";
    }

    public List<Movie>findAllMovies(){
        List<Movie> movieList=new ArrayList<>();
        for(Movie movie:movieDb.values()){
            movieList.add(movie);
        }
        return movieList;
    }
}
