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
        return "Hello World welcome to my application";
    }

    @GetMapping("/findall")
    public String findAll(){
        MovieDataRepository movieDataRepository = new MovieDataRepository();
        List<Movie> movieList = movieDataRepository.findAll();
        return "all movies:" + movieList;

    }
}
