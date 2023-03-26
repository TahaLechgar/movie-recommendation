package com.example.movie;

import com.example.movie.controller.MovieController;
import com.example.movie.entity.Movie;
import com.example.movie.repository.MovieRepository;
import com.example.movie.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith     (MockitoExtension.class)
class MovieControllerTests {


    @InjectMocks
    private MovieController movieController;

    @Mock
    private MovieService movieService;

    Movie MOVIE_1 = new Movie(1L, "The Shawshank Redemption", "Drama", 1994, "Frank Darabont");
    Movie MOVIE_2 = new Movie(null, "The Godfather", "Drama", 1972, "Francis Ford Coppola");
    Movie MOVIE_3 = new Movie(null, "The Dark Knight", "Action", 2008, "Christopher Nolan");



    @BeforeEach
    public void setup() {
        List<Movie> movies = new ArrayList<>(Arrays.asList(MOVIE_1, MOVIE_2, MOVIE_3));

        Mockito.when(movieService.findAll()).thenReturn(movies);
    }

    @Test
    @DisplayName("The response code should be 200 OK")
    void should_return_status_ok() throws Exception {

        ResponseEntity<List<Movie>> responseEntity = movieController.findAll();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }


    @Test
    @DisplayName("The response body should have 3 movies")
    void should_return_three_movies() throws Exception {
        ResponseEntity<List<Movie>> responseEntity = movieController.findAll();

        assertEquals(3, Objects.requireNonNull(responseEntity.getBody()).size());
    }

}

