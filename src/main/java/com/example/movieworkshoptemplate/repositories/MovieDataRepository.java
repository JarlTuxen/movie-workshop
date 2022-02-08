package com.example.movieworkshoptemplate.repositories;

import com.example.movieworkshoptemplate.models.Movie;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MovieDataRepository {
    //Methods to get data from file

    public List<Movie> findAll() {
        List<Movie> movieList = new LinkedList<>();

        try
        {
            File file = new ClassPathResource("imdb-data.csv").getFile();
            Scanner input = new Scanner(file);
            //Scanner input = new Scanner(new File("imdb-data.csv"));
            //skip headers
            System.out.println(input.nextLine());
            while (input.hasNextLine()){
                //read line and create movie
                //Year;Length;Title;Subject;Popularity;Awards

                //use scanner to read line
                Scanner line = new Scanner(input.nextLine()).useDelimiter(";");

                Movie movie = new Movie();
                movie.setYear(line.nextInt());
                movie.setLength(line.nextInt());
                movie.setTitle(line.next());
                movie.setSubject(line.next());
                movie.setPopularity(line.nextInt());
                String award = line.next();
                movie.setAwards(award.equals("Yes"));

                movieList.add(movie);
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error reading file: " + e);
        }
        catch (IOException e)
        {
            System.out.println("IO Exception: " + e);
        }
        return movieList;
    }
}
