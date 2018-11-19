import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Movie } from './movie'

@Component({
  selector: 'movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  @Input()
  private movies: Movie[] = []

  @Output()
  private onSelect: EventEmitter<Movie> = new EventEmitter()

  constructor() {
    this.movies.push(new Movie(1, 'Manchester by the sea'))
    this.movies.push(new Movie(1, 'Hotel budapest'))
  }

  ngOnInit() {
  }

  public selectMovie(index: number) {
    const selectedMovie = this.movies[index]
    this.onSelect.emit(selectedMovie)
  }

}
