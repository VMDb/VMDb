import { Component, OnInit } from '@angular/core';
import { MovieForm } from '../model/movie';
import { MovieService } from '../movie/movie.service';

@Component({
  selector: 'app-create-movie',
  templateUrl: './create-movie.component.html',
  styleUrls: ['./create-movie.component.css']
})
export class CreateMovieComponent implements OnInit {

  movieForm: MovieForm

  title: string;

  duration: number;

  releaseDate: Date;

  constructor(private movieService: MovieService) {
    
  }

  ngOnInit() {
  }

  submit(){
    //Test
    this.movieForm = new MovieForm(this.title, this.releaseDate, this.duration, null, null, null, null, null, null, null, null, null, null);
    console.log(this.movieForm);
    this.movieService.save(this.movieForm);
  }
}
