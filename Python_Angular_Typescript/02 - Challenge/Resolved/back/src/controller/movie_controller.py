from typing import List
from fastapi import APIRouter, HTTPException
from src.model.movie import Movie
from src.service.movie_service import MovieService

router = APIRouter()

movie_service = MovieService()

@router.get("/movies", response_model=List[Movie])
def get_all_movies():
    return movie_service.get_all_movies()

@router.get("/movies/{movie_id}", response_model=Movie)
def get_movie_by_id(movie_id: int):
    return movie_service.get_movie_by_id(movie_id)

@router.post("/movies", response_model=Movie)
def create_movie(movie: Movie):
    return movie_service.save_movie(movie)

@router.patch("/movies/{movie_id}", response_model=Movie)
def update_movie(movie_id: int, movie: Movie):
    return movie_service.update_movie(movie_id, movie)

@router.delete("/movies/{movie_id}")
def delete_movie(movie_id: int):
    movie_service.delete_movie(movie_id)
    return {"message": "Movie deleted successfully"}