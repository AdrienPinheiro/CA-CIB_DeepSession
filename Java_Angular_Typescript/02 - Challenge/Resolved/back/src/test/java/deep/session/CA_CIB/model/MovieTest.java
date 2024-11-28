package deep.session.CA_CIB.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidMovie() {
        Movie movie = new Movie();
        movie.setTitle("Inception");
        movie.setDirector("Christopher Nolan");
        movie.setReleaseYear(2010);

        Set<ConstraintViolation<Movie>> violations = validator.validate(movie);
        assertTrue(violations.isEmpty(), "The movie should be valid with no constraint violations.");
    }

    @Test
    public void testTitleIsMandatory() {
        Movie movie = new Movie();
        movie.setDirector("Christopher Nolan");
        movie.setReleaseYear(2010);

        Set<ConstraintViolation<Movie>> violations = validator.validate(movie);
        assertEquals(1, violations.size(), "There should be one violation for missing title.");
        assertEquals("Title is mandatory", violations.iterator().next().getMessage());
    }

    @Test
    public void testDirectorIsMandatory() {
        Movie movie = new Movie();
        movie.setTitle("Inception");
        movie.setReleaseYear(2010);

        Set<ConstraintViolation<Movie>> violations = validator.validate(movie);
        assertEquals(1, violations.size(), "There should be one violation for missing director.");
        assertEquals("Director is mandatory", violations.iterator().next().getMessage());
    }

    @Test
    public void testReleaseYearIsNotLessThan1888() {
        Movie movie = new Movie();
        movie.setTitle("Inception");
        movie.setDirector("Christopher Nolan");
        movie.setReleaseYear(1800);

        Set<ConstraintViolation<Movie>> violations = validator.validate(movie);
        assertEquals(1, violations.size(), "There should be one violation for release year being less than 1888.");
        assertEquals("Release year should not be less than 1888", violations.iterator().next().getMessage());
    }
}
