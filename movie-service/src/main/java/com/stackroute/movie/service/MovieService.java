package com.stackroute.movie.service;

import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.exceptions.MovieAlreadyExistsException;
import com.stackroute.movie.exceptions.MovieNotFoundException;

import java.util.List;

public interface MovieService {

    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException,Exception;
    public List<Movie> getAllMovies() throws Exception;
    public Movie deleteMovie(int movieId) throws MovieNotFoundException, Exception;
    public void updateMovie(Movie movie) throws MovieNotFoundException, Exception;
    public List<Movie> findByName(String name) throws MovieNotFoundException, Exception;
}
