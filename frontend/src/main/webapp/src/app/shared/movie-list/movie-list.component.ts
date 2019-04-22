import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Movie } from './movie'

import { MovieService } from '../movie/movie.service';

@Component({
  selector: 'movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  movies: Movie[]

  // TODO: Assigne movie when you select one.
  selectedMovie: Movie

  @Output()
  private onSelect: EventEmitter<Movie> = new EventEmitter()

  constructor(private movieService: MovieService) {
    this.movies = [];
    this.onSelect.subscribe(movie => {

    });
  }

  ngOnInit() {
  this.movieService.getAll().subscribe(data => {
      this.movies = data;
    });
  }

  public selectMovie(movie: Movie) {
    this.selectedMovie = movie;
    this.onSelect.emit(movie);
  }

}
