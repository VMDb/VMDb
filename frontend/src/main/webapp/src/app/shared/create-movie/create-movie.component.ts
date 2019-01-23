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

  constructor(private movieService: MovieService) {
    //Not my proudest line of code..
    this.movieForm = new MovieForm(null,null,null,null,null,null,null,null,null,null,null,null,null);
  }

  ngOnInit() {
  }

  submit(){
    //Test

    console.log(this.movieForm);
    this.movieService.save(this.movieForm);
  }
}
