package com.stackroute.movie.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    private int movieId;
    private String original_title;
    private String overview;
    private String tagline;
    private double vote_average;

}
