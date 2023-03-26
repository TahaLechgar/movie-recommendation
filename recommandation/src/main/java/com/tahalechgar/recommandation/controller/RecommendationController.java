package com.tahalechgar.recommandation.controller;

import com.tahalechgar.recommandation.client.MovieClient;
import com.tahalechgar.recommandation.dto.MovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
@RequiredArgsConstructor
public class RecommendationController {

    private final MovieClient movieClient;

    @GetMapping
    public ResponseEntity<List<MovieDto>> getRecommendations(@RequestParam(name = "genre") String genre) {
        List<MovieDto> movies =  movieClient.findAllMovies();
        List<MovieDto> recommendations = movies.stream()
                .filter(movieDto -> genre.equals(movieDto.getGenre()))
                .toList();

        return ResponseEntity.ok().body(recommendations);
    }
}