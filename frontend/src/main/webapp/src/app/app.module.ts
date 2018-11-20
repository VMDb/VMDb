import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MovieListComponent } from './shared/movie-list/movie-list.component';
import { HttpClientModule } from '@angular/common/http'; 
import { CommonModule } from '@angular/common'

import { MovieService } from './shared/movie/movie.service';

@NgModule({
  declarations: [
    AppComponent,
    MovieListComponent
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
