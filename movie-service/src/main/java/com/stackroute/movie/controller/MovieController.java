package com.stackroute.movie.controller;

import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.exceptions.MovieAlreadyExistsException;
import com.stackroute.movie.exceptions.MovieNotFoundException;
import com.stackroute.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/movie-service")
public class MovieController {
    @Autowired
    private MovieService movieService;
    private ResponseEntity responseEntity;
    @PostMapping("movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie) throws Exception {
        try {
            responseEntity = new ResponseEntity<Movie>(movieService.saveMovie(movie), HttpStatus.CREATED);
        } catch (MovieAlreadyExistsException e)
        {
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
    @GetMapping("movies")
    public ResponseEntity<?> getAllMovies() throws Exception {
        try {
            responseEntity = new ResponseEntity<List<Movie>>(movieService.getAllMovies(),HttpStatus.OK);
        }catch (Exception e)
        {
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @PutMapping("movie")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie) throws Exception
    {
        try {
            movieService.updateMovie(movie);
            responseEntity = new ResponseEntity<String>("Successfully updated", HttpStatus.OK);
        } catch (Exception e)
        {
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @DeleteMapping("movie/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable int movieId) throws Exception
    {
        try {
            responseEntity = new ResponseEntity<Movie>(movieService.deleteMovie(movieId), HttpStatus.OK);
        } catch (Exception e)
        {
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("movie/search={name}")
    public ResponseEntity<?> findByName(@PathVariable String name) throws Exception {
        try {
            responseEntity = new ResponseEntity<List<Movie>>(movieService.findByName(name), HttpStatus.OK);
        }catch (MovieNotFoundException e)
        {
            responseEntity  = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
