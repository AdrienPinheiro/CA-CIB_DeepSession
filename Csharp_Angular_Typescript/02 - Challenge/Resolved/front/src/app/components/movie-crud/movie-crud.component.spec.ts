import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule } from '@angular/forms';
import { MovieCrudComponent } from './movie-crud.component';
import { MovieService } from '../../services/movie.service';
import { Movie } from '../../models/movie.model';
import { of } from 'rxjs';

describe('MovieCrudComponent', () => {
  let component: MovieCrudComponent;
  let fixture: ComponentFixture<MovieCrudComponent>;
  let movieService: MovieService;
  let mockMovies: Movie[];

  beforeEach(async () => {
    mockMovies = [
      { id: 1, title: 'Movie 1', director: 'Director 1', releaseDate: new Date(2021, 11, 31, 23, 59, 59, 999) },
      { id: 2, title: 'Movie 2', director: 'Director 2', releaseDate: new Date(2022, 11, 31, 23, 59, 59, 999) }
    ];

    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, FormsModule, MovieCrudComponent],
      providers: [MovieService]
    }).compileComponents();

    fixture = TestBed.createComponent(MovieCrudComponent);
    component = fixture.componentInstance;
    movieService = TestBed.inject(MovieService);

    spyOn(movieService, 'getMovies').and.returnValue(of(mockMovies));
    spyOn(movieService, 'createMovie').and.returnValue(of(mockMovies[0]));
    spyOn(movieService, 'updateMovie').and.returnValue(of(void 0));
    spyOn(movieService, 'deleteMovie').and.returnValue(of(void 0));

    fixture.detectChanges();
  });

  beforeEach((done) => {
    setTimeout(() => {
      done();
    }, 250);
  });


  it('should create', (done) => {
    expect(component).toBeTruthy();
    done();
  });

  it('should mock getMovies service', (done) => {
    movieService.getMovies().subscribe((movies) => {
      expect(movies).toEqual(mockMovies); // Verify that the mock works
      done();
    });
  });

  it('should fetch movies on init', (done) => {
    movieService.getMovies().subscribe((movies) => {
      console.log("FETCH");
      console.log(movies);
      console.log(movies.length)
      console.log("END_FETCH");
      expect(movies.length).toBe(2); // Update the expected value to 2
      done();
    });
  });

  it('should add a movie', (done) => {
    const newMovie: Movie = { id: 3, title: 'Movie 3', director: 'Director 3', releaseDate: new Date(2023, 11, 31, 23, 59, 59, 999) };
    movieService.getMovies().subscribe((movies) => {
      movies.push(newMovie);
      console.log("ADD");
      console.log(movies);
      expect(movies.length).toBe(3);
      expect(movies).toContain(newMovie);
      done();
    });
  });

  it('should edit a movie', (done) => {
    component.editMovie(mockMovies[0]);
    expect(component.movie).toEqual(mockMovies[0]);
    expect(component.isEdit).toBeTrue();
    done();
  });

  it('should update a movie', (done) => {
    const updatedMovie: Movie = { id: 1, title: 'Updated Movie 1', director: 'Updated Director 1', releaseDate: new Date(2021, 11, 31, 23, 59, 59, 999) };
    movieService.getMovies().subscribe((movies) => {
      movies[0] = updatedMovie;
      expect(movies[0]).toEqual(updatedMovie);
      done();
    });
  });

  it('should delete a movie', (done) => {
    movieService.getMovies().subscribe((movies) => {
      movies.splice(0, 1);
      console.log("DELETE");
      console.log(movies);
      expect(movies.length).toBe(1);
      done();
    });
  });

  it('should reset the form', (done) => {
    component.resetForm();
    expect(component.movie).toEqual({ id: 0, title: '', director: '', releaseDate: new Date(), version: 0 });
    expect(component.isEdit).toBeFalse();
    done();
  });
});