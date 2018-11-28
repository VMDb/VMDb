import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Movie } from './movie'

import { MovieService } from '../movie/movie.service';

@Component({
  selector: 'movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  movies: Array<any>;

  @Output()
  private onSelect: EventEmitter<Movie> = new EventEmitter()

  constructor(private movieService: MovieService) {
  
  }

  ngOnInit() {
  this.movieService.getAll().subscribe(data => {
      this.movies = data;
    });
  }

  public selectMovie(index: number) {
    const selectedMovie = this.movies[index]
    this.onSelect.emit(selectedMovie)
  }

}
