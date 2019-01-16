import { Component, OnInit } from '@angular/core';
import { MovieForm } from '../model/movie-form';

@Component({
  selector: 'app-create-movie',
  templateUrl: './create-movie.component.html',
  styleUrls: ['./create-movie.component.css']
})
export class CreateMovieComponent implements OnInit {

  private movieForm: MovieForm

  constructor() {
    
  }

  ngOnInit() {
  }

  submit(){
    console.log(this.movieForm);
  }
}
