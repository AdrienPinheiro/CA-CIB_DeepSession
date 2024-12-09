// src/app/components/movie-crud/movie-crud.component.ts
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MovieService } from '../../services/movie.service';
import { Movie } from '../../models/movie.model';

@Component({
  selector: 'app-movie-crud',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './movie-crud.component.html',
  styleUrls: ['./movie-crud.component.scss'],
  providers: [MovieService]
})
export class MovieCrudComponent implements OnInit {
  movies: Movie[] = [];
  movie: Movie = { title: '', director: '', release_year: 0 };
  isEdit = false;

  constructor(private movieService: MovieService) {}

  ngOnInit(): void {
    this.getMovies();
  }

  getMovies(): void {
    this.movieService.getMovies().subscribe((movies) => {
      this.movies = movies;
    });
  }

  addMovie(): void {
    this.movieService.createMovie(this.movie).subscribe((movie) => {
        this.movies.push(movie);
        this.resetForm();
    });
}

  editMovie(movie: Movie): void {
    this.movie = { ...movie };
    this.isEdit = true;
  }

  updateMovie(): void {
    console.log(this.movie);    
    if(this.movie.id === undefined) return;
    else this.movieService.updateMovie(this.movie.id, this.movie).subscribe(() => {
        this.getMovies();
        this.resetForm();
    });
}

  deleteMovie(id: number): void {
    this.movieService.deleteMovie(id).subscribe(() => {
      this.movies = this.movies.filter((movie) => movie.id !== id);
    });
  }

  resetForm(): void {
    this.movie = { id: 0, title: '', director: '', release_year: 0, version: 0 };
    this.isEdit = false;
  }
}