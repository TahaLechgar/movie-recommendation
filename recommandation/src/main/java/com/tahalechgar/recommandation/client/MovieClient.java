package com.tahalechgar.recommandation.client;

import com.tahalechgar.recommandation.dto.MovieDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "MOVIE-SERVICE", url = "http://localhost:8080")
public interface MovieClient {

    @GetMapping(value = "/movies")
    List<MovieDto> findAllMovies();

}
