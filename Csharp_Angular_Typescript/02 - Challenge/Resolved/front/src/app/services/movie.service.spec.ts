import { TestBed } from '@angular/core/testing';
import {
  HttpTestingController,
  provideHttpClientTesting,
} from '@angular/common/http/testing';
import { provideHttpClient } from '@angular/common/http';
import { MovieService } from './movie.service';
import { Movie } from '../models/movie.model';

describe('MovieService', () => {
  let apiUrl = 'http://localhost:5281/api/movies';
  let service: MovieService;
  let httpMock: HttpTestingController;
  const mockMovies: Movie[] = [
    {
      id: 1,
      title: 'Movie 1',
      director: 'Director 1',
      releaseDate: new Date(2022, 11, 31, 23, 59, 59, 999),
      version: 0,
    },
    {
      id: 2,
      title: 'Movie 2',
      director: 'Director 2',
      releaseDate: new Date(2021, 11, 31, 23, 59, 59, 999),
      version: 1,
    },
  ];

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [],
      providers: [
        MovieService,
        provideHttpClient(),
        provideHttpClientTesting(),
      ],
    });
    service = TestBed.inject(MovieService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should fetch movies', () => {
    service.getMovies().subscribe((movies) => {
      expect(movies.length).toBe(2);
      expect(movies).toEqual(mockMovies);
    });

    const req = httpMock.expectOne(apiUrl);
    expect(req.request.method).toBe('GET');
    req.flush(mockMovies);
  });

  it('should fetch a movie by id', () => {
    service.getMovieById(1).subscribe((movie) => {
      expect(movie).toEqual(mockMovies[0]);
    });

    const req = httpMock.expectOne(apiUrl+'/1');
    expect(req.request.method).toBe('GET');
    req.flush(mockMovies[0]);
  });

  it('should create a movie', () => {
    const newMovie: Movie = {
      id: 3,
      title: 'Movie 3',
      director: 'Director 3',
      releaseDate: new Date(2023, 11, 31, 23, 59, 59, 999),
      version: 2,
    };
    service.createMovie(newMovie).subscribe((movie) => {
      expect(movie).toEqual(newMovie);
    });

    const req = httpMock.expectOne(apiUrl);
    expect(req.request.method).toBe('POST');
    req.flush(newMovie);
  });

  it('should update a movie', () => {
    const updatedMovie: Movie = {
      id: 1,
      title: 'Updated Movie 1',
      director: 'Updated Director 1',
      releaseDate: new Date(2021, 11, 31, 23, 59, 59, 999),
      version: 1,
    };
    service.updateMovie(1, updatedMovie).subscribe(() => {
      expect().nothing();
    });

    const req = httpMock.expectOne(apiUrl+'/1');
    expect(req.request.method).toBe('PATCH');
    req.flush(null);
  });

  it('should delete a movie', () => {
    service.deleteMovie(1).subscribe(() => {
      expect().nothing();
    });

    const req = httpMock.expectOne(apiUrl+'/1');
    expect(req.request.method).toBe('DELETE');
    req.flush(null);
  });
});
