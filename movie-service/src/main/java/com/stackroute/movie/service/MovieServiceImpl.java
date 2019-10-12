package com.stackroute.movie.service;

import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.exceptions.MovieAlreadyExistsException;
import com.stackroute.movie.exceptions.MovieNotFoundException;
import com.stackroute.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;
    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException, Exception {
        if(movieRepository.existsById(movie.getMovieId()))
        {
            throw new MovieAlreadyExistsException("Movie already exists");
        }
        Movie savedMovie = movieRepository.save(movie);
        if(savedMovie==null)
        {
            throw new MovieAlreadyExistsException("Movie already exists");
        }
        return savedMovie;
    }
    @Override
    public List<Movie> getAllMovies() throws Exception {
        return movieRepository.findAll();
    }
    @Override
    public Movie deleteMovie(int movieId) throws MovieNotFoundException, Exception {
        if(movieRepository.existsById(movieId))
        {
            Movie tmovie = movieRepository.findById(movieId).get();
            movieRepository.deleteById(movieId);
            return tmovie;
        }
        else
        {
            throw new MovieNotFoundException("Movie not Found");
        }
    }
    @Override
    public void updateMovie(Movie movie) throws MovieNotFoundException, Exception {
        if(movieRepository.existsById(movie.getMovieId()))
        {
            movieRepository.deleteById(movie.getMovieId());
            movieRepository.save(movie);
        }
        else
        {
            throw new MovieNotFoundException("Movie Not Found");
        }
    }

    @Override
    public List<Movie> findByName(String name) throws MovieNotFoundException, Exception {
        if(movieRepository.findByName(name).isEmpty())
        {
            throw new MovieNotFoundException("Movie Not Found");
        }
        return movieRepository.findByName(name);
    }
}
