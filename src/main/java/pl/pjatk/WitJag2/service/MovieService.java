package pl.pjatk.WitJag2.service;

import org.springframework.stereotype.Service;
import pl.pjatk.WitJag2.model.Category;
import pl.pjatk.WitJag2.model.Movie;

import java.util.List;

@Service
public class MovieService {
    private List<Movie> movies;

    public MovieService() {
        this.movies = List.of(
                new Movie(1L, "Beemovie", Category.animated),
                new Movie(2L, "Dzien Swira", Category.comedy),
                new Movie(3L, "Chlopaki nie placza", Category.comedy)

        );
    }


    public List<Movie> addMovie(Movie addMovie) {
        if (addMovie.getName().equals("")) {
            return null;
        }

        this.movies.add(addMovie);

        return this.movies;
    }

    public List<Movie> getAllMovies() {
        return this.movies;
    }


    public Movie getMovie(Long movieId) {
        for (Movie movie : this.movies) {
            if (movie.getId().equals(movieId)) {
                return movie;
            }
        }
        return null;
    }

    public boolean removeMovie(Long id) {
        return this.movies.removeIf(e -> e.getId().equals(id));
    }


    public Movie update(Movie movie) {
        Long movieId = movie.getId();
        Movie movieToUpdate = this.getMovie(movieId);
        if (movieToUpdate == null) {
            return null;
        }

        movieToUpdate.setName(movie.getName());
        movieToUpdate.setCategory(movie.getCategory());

        return movieToUpdate;
    }


}

