package com.example.movieworkshoptemplate.repositories;

import com.example.movieworkshoptemplate.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MovieDataRepository {
    //Methods to get data from file

    public List<Movie> findAll() {
        List<Movie> movieList = new LinkedList<>();

        try
        {
            Scanner input = new Scanner(new File("imdb-data.scv"));
            while (input.hasNextLine()){
                System.out.println(input.nextLine());
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error reading file: " + e);
        }
        return movieList;
    }
}
