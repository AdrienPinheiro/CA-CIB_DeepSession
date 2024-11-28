package deep.session.CA_CIB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import deep.session.CA_CIB.model.Movie;
import deep.session.CA_CIB.service.MovieService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movies")
@Validated
public class MovieController {
    @Autowired
    private MovieService movieService;

    // Récupérer tous les films
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // Récupérer un film par ID
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    // Créer un nouveau film
    @PostMapping
    public ResponseEntity<String> createMovie(@Valid @RequestBody Movie movie) {
        movieService.saveMovie(movie);
        return new ResponseEntity<>("Movie created successfully", HttpStatus.CREATED);
    }

    // Mettre à jour un film existant
    @PutMapping("/{id}")
    public ResponseEntity<String> updateMovie(@PathVariable Long id, @Valid @RequestBody Movie movie) {
        movie.setId(id);
        movieService.saveMovie(movie);
        return new ResponseEntity<>("Movie updated successfully", HttpStatus.OK);
    }

    // Supprimer un film par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return new ResponseEntity<>("Movie deleted successfully", HttpStatus.OK);
    }
}