import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MovieComponent } from '../app/shared/movie/movie.component';
import { MovieListComponent } from '../app/shared/movie-list/movie-list.component';
import { MoviePreviewComponent } from '../app/shared/movie-preview/movie-preview.component';
import { CreateMovieComponent } from '../app/shared/create-movie/create-movie.component';
import { ViewMovieComponent } from './shared/view-movie/view-movie.component';


const routes: Routes = [
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: 'home', component: MovieComponent },
    { path: 'view/:id', component: ViewMovieComponent },
    { path: 'movie/new', component: CreateMovieComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
