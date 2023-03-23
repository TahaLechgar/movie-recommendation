package com.example.movie;

import com.example.movie.entity.Movie;
import com.example.movie.repository.MovieRepository;
import com.example.movie.service.MovieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class  MovieApplication implements CommandLineRunner {

    private final MovieService movieService;

    public MovieApplication(MovieService movieService) {
        this.movieService = movieService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        movieService.save(new Movie(null, "The Shawshank Redemption", "Drama", 1994, "Frank Darabont"));
        movieService.save(new Movie(null, "The Godfather", "Drama", 1972, "Francis Ford Coppola"));
        movieService.save(new Movie(null, "The Dark Knight", "Action", 2008, "Christopher Nolan"));
    }
}
