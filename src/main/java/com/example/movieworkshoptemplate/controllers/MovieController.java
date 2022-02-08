package com.example.movieworkshoptemplate.controllers;

import com.example.movieworkshoptemplate.models.Movie;
import com.example.movieworkshoptemplate.repositories.MovieDataRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    //Controller methods
    @GetMapping("/")
    public String index(){
        return "Hello World welcome to my application" +
                "/getFirst" +
                "/getRandom" +
                "/getTenSortByPopularity" +
                "/howManyWonAnAward" +
                "(Advanced) /filter?char=’x’amount=’n’" +
                "(Advanced) /longest?g1=’x’g2=’y’";
    }

    @GetMapping("/findall")
    public String findAll(){
        MovieDataRepository movieDataRepository = new MovieDataRepository();
        List<Movie> movieList = movieDataRepository.findAll();
        String movies = "<h1>All movies</h1>";
        for (Movie m:movieList){
            movies += m.toString() + "<br>";
        }
        /* lambda expression
        String movies = movieList
                .stream()
                .reduce("", (substring, element) -> substring + element.toString() + "<br>", String::concat);
        */
        return movies;

    }
}
