from fastapi import HTTPException

class MovieNotFoundException(HTTPException):
    def __init__(self, detail: str):
        super().__init__(status_code=404, detail=detail)

class MovieAlreadyExistsException(HTTPException):
    def __init__(self, detail: str):
        super().__init__(status_code=409, detail=detail)