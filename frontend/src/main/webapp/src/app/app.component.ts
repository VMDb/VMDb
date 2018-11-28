import { Component } from '@angular/core';
import { Movie } from './shared/movie-list/movie'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  selectedMovie: Movie
}
