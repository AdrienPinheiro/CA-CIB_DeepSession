// src/app/app.routes.ts
import { Routes } from '@angular/router';
import { MovieListComponent } from './components/movie-list/movie-list.component';
import { MovieCrudComponent } from './components/movie-crud/movie-crud.component';

export const routes: Routes = [
  { path: '', redirectTo: '/movies', pathMatch: 'full' },
  { path: 'movies', component: MovieListComponent },
  { path: 'crud', component: MovieCrudComponent }
];