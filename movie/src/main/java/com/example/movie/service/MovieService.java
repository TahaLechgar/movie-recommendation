package com.example.movie.service;


import com.example.movie.entity.Movie;
import com.example.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieService {
    private final MovieRepository movieRepository;

    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Transactional
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

}
