package pl.pjatk.WitJag2.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.WitJag2.model.Movie;
import pl.pjatk.WitJag2.service.MovieService;

import java.util.List;


@RestController
@RequestMapping("/test")
public class MovieRestController {

    private final MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping("/model")

    public ResponseEntity<Movie> getCar() {
        Movie BeeMovie = MovieService.getMovie((long) 1);
        return ResponseEntity.ok(BeeMovie);
    }

    @PostMapping("/model")
    public ResponseEntity<Movie> getCarPost(@RequestBody Movie movie) {

        return ResponseEntity.ok(movie);
    }

    @GetMapping("/exeption")
    public ResponseEntity<String> throwExeption() {
        movieService.throwException("Testing bla bla bla");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(MovieService.getAllMovies());
    }


}