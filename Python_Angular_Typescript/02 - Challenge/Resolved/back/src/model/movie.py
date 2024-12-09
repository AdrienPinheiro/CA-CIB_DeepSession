from pydantic import BaseModel, Field

class Movie(BaseModel):
    id: int = None
    title: str = Field(..., description="Title is mandatory")
    director: str = Field(..., description="Director is mandatory")
    release_year: int = Field(..., ge=1888, description="Release year should not be less than 1888")