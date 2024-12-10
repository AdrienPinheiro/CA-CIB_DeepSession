from typing import List, Optional
from src.model.movie import Movie

class MovieRepository:
    def __init__(self):
        self.movies = []
        self.current_id = 1

    def find_all(self) -> List[Movie]:
        return self.movies

    def find_by_id(self, movie_id: int) -> Optional[Movie]:
        for movie in self.movies:
            if movie.id == movie_id:
                return movie
        return None

    def exists_by_title_and_director(self, title: str, director: str) -> bool:
        for movie in self.movies:
            if movie.title == title and movie.director == director:
                return True
        return False

    def save(self, movie: Movie) -> Movie:
        if movie.id is None:
            movie.id = self.current_id
            self.current_id += 1
            self.movies.append(movie)
        else:
            for i, existing_movie in enumerate(self.movies):
                if existing_movie.id == movie.id:
                    self.movies[i] = movie
                    break
        return movie

    def delete_by_id(self, movie_id: int) -> None:
        self.movies = [movie for movie in self.movies if movie.id != movie_id]