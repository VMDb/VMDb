import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MovieListComponent } from './shared/movie-list/movie-list.component';
import { MovieComponent } from './shared/movie/movie.component';
import { HttpClientModule } from '@angular/common/http'; 
import { CommonModule } from '@angular/common'

import { MovieService } from './shared/movie/movie.service';
import { MoviePreviewComponent } from './shared/movie-preview/movie-preview.component';

@NgModule({
  declarations: [
    MovieComponent,
    AppComponent,
    MovieListComponent,
    MoviePreviewComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    CommonModule
  ],
  providers: [MovieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
