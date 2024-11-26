package deep.session.CA_CIB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import deep.session.CA_CIB.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    boolean existsByTitleAndDirector(String title, String director);
}