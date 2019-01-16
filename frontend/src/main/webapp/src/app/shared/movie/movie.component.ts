import { Movie } from '../movie-list/movie'
import { Component } from '@angular/core'

// TODO: Don't forget to register it in the module.
@Component({
  selector: 'movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent {

  movie: Movie;

  public selectMovie(movie: Movie){
    this.movie = movie;
    
  }

}
