package pl.pjatk.WitJag2.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.WitJag2.model.Movie;
import pl.pjatk.WitJag2.service.MovieService;

import java.util.List;


@RestController
@RequestMapping("/movies")
public class MovieRestController {
    private MovieService movieService;
    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping()
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(this.movieService.getAllMovies());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        return ResponseEntity.ok(this.movieService.getMovie(id));
    }

    @PostMapping()
    public ResponseEntity addMovie(@RequestBody Movie movieToAdd){
        List<Movie> movies = this.movieService.addMovie(movieToAdd);

        if(movies == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok().build();
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        boolean isRemoved = this.movieService.removeMovie(id);
        if(isRemoved) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }



    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movieToUpdate){
        Movie movie = this.movieService.update(movieToUpdate);

        if(movie == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok().build();
    }
}




