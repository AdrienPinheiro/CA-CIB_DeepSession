from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from src.controller import movie_controller

app = FastAPI()

# CORS configuration
origins = [
    "http://localhost:4200",
]

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

app.include_router(movie_controller.router)

@app.get("/")
def read_root():
    return {"message": "Hello, CA-CIB!"}

if __name__ == '__main__':
    import uvicorn
    uvicorn.run(app, host="0.0.0.0", port=8000)