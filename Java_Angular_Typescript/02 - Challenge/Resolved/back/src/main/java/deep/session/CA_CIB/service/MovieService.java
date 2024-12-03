package deep.session.CA_CIB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import deep.session.CA_CIB.exception.MovieAlreadyExistsException;
import deep.session.CA_CIB.exception.MovieNotFoundException;
import deep.session.CA_CIB.model.Movie;
import deep.session.CA_CIB.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("Movie not found with id: " + id));
    }

    @Transactional
    public Movie saveMovie(Movie movie) {
        if (movieRepository.existsByTitleAndDirector(movie.getTitle(), movie.getDirector())) {
            throw new MovieAlreadyExistsException("Movie already exists with title: " + movie.getTitle() + " and director: " + movie.getDirector());
        }
        return movieRepository.save(movie);
    }

    @Transactional
    public Movie updateMovie(Long id, Movie movie) {
        Movie existingMovie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("Movie not found with id: " + id));
        if (!existingMovie.getTitle().equals(movie.getTitle()) || !existingMovie.getDirector().equals(movie.getDirector())) {
            if (movieRepository.existsByTitleAndDirector(movie.getTitle(), movie.getDirector())) {
                throw new MovieAlreadyExistsException("Movie already exists with title: " + movie.getTitle() + " and director: " + movie.getDirector());
            }
        }
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setDirector(movie.getDirector());
        existingMovie.setReleaseYear(movie.getReleaseYear());
        return movieRepository.save(existingMovie);
    }

    @Transactional
    public void deleteMovie(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new MovieNotFoundException("Movie not found with id: " + id);
        }
        movieRepository.deleteById(id);
    }
}