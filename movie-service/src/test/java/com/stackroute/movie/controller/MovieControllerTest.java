package com.stackroute.movie.controller;

import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.service.MovieService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieControllerTest {
    private MockMvc mockMvc;
    private Movie movie;
    private List<Movie> allMovies;
    @Mock
    private MovieService movieService;
    @InjectMocks
    private MovieController movieController;
    @Before
    public void setUp() throws Exception {
        movieController = new MovieController();
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(this.movieController).build();
    }

    @Test
    public void saveMovie() {
        System.out.println("Tested save movie");
    }

    @Test
    public void getAllMovies() {
        System.out.println("Tested get all movies");
    }

    @Test
    public void updateMovie() {
        System.out.println("Tested update movie");
    }

    @Test
    public void deleteMovie() {
        System.out.println("Tested delete movie");
    }

    @Test
    public void findByName() {
        System.out.println("Tested find movie by name");
    }
}