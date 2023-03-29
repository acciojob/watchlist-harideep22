package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){

        String ans=movieService.addMovie(movie);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){

        String ans=movieService.addDirector(director);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName")String movieName,
                                                       @RequestParam("directorName")String directorName){

        String ans=movieService.pairMoieDirector(movieName,directorName);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("movieName")String movieName){
        Movie ans=movieService.getMovieByName(movieName);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("directorName")String directorName){
        Director ans=movieService.getDirectorByName(directorName);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<Movie>> getMoviesByDirectorName(@PathVariable("directorName")String directorName){
        List<Movie> movieList=movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(movieList,HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){
        List<Movie> movieList=movieService.findAllMovies();
        return new ResponseEntity<>(movieList,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("directorName")String directorName){
        String ans=movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        String ans=movieService.deleteAllDirectors();
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }

}