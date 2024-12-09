from typing import List
from src.model.movie import Movie
from src.repository.movie_repository import MovieRepository
from fastapi import HTTPException

class MovieService:
    def __init__(self):
        self.movie_repository = MovieRepository()

    def get_all_movies(self) -> List[Movie]:
        return self.movie_repository.find_all()

    def get_movie_by_id(self, movie_id: int) -> Movie:
        movie = self.movie_repository.find_by_id(movie_id)
        if not movie:
            raise HTTPException(status_code=404, detail="Movie not found")
        return movie

    def save_movie(self, movie: Movie) -> Movie:
        if self.movie_repository.exists_by_title_and_director(movie.title, movie.director):
            raise HTTPException(status_code=409, detail="Movie already exists")
        return self.movie_repository.save(movie)

    def update_movie(self, movie_id: int, movie: Movie) -> Movie:
        existing_movie = self.movie_repository.find_by_id(movie_id)
        if not existing_movie:
            raise HTTPException(status_code=404, detail="Movie not found")
        if (existing_movie.title != movie.title or existing_movie.director != movie.director) and \
                self.movie_repository.exists_by_title_and_director(movie.title, movie.director):
            raise HTTPException(status_code=409, detail="Movie already exists")
        existing_movie.title = movie.title
        existing_movie.director = movie.director
        existing_movie.release_year = movie.release_year
        return self.movie_repository.save(existing_movie)

    def delete_movie(self, movie_id: int) -> None:
        if not self.movie_repository.find_by_id(movie_id):
            raise HTTPException(status_code=404, detail="Movie not found")
        self.movie_repository.delete_by_id(movie_id)