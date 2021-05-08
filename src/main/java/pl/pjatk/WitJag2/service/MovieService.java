package pl.pjatk.WitJag2.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import pl.pjatk.WitJag2.model.Movie;

import java.util.List;

@Service
public class MovieService {



    public static List<Movie> getAllMovies() {
        Movie firstMovie = new Movie(1L,"Beemovie","animation");
        Movie secoundMovie = new Movie(2l,"Dzien Swira","comedy");
        Movie thirdMovie = new Movie(3l,"Chlopaki nie placza","comedy");
        return List.of(
                firstMovie,
                secoundMovie,
                thirdMovie

        );
    }

    public static Movie getMovie( long l) {
    }
}

