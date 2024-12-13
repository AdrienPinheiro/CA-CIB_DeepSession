import pytest
from pydantic import ValidationError
from src.model.movie import Movie

def test_valid_movie():
    movie = Movie(title="Inception", director="Christopher Nolan", release_year=2010)
    assert isinstance(movie, Movie)

def test_title_is_mandatory():
    with pytest.raises(ValidationError) as excinfo:
        Movie(director="Christopher Nolan", release_year=2010)
    assert "Field required" in str(excinfo.value)

def test_director_is_mandatory():
    with pytest.raises(ValidationError) as excinfo:
        Movie(title="Inception", release_year=2010)
    assert "Field required" in str(excinfo.value)

def test_release_year_is_not_less_than_1888():
    with pytest.raises(ValidationError) as excinfo:
        Movie(title="Inception", director="Christopher Nolan", release_year=1800)
    assert "greater than or equal to 1888" in str(excinfo.value)