import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MovieComponent } from '../app/shared/movie/movie.component';
import { MovieListComponent } from '../app/shared/movie-list/movie-list.component';
import { MoviePreviewComponent } from '../app/shared/movie-preview/movie-preview.component';


const routes: Routes = [
    { path: 'home', component: MovieComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
