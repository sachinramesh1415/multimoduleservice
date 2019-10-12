package com.stackroute.movie.repository;

import com.stackroute.movie.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, Integer> {
    @Query("{'original_title' : ?0 }")
    public List<Movie> findByName(@Param("chars") String chars);
}
