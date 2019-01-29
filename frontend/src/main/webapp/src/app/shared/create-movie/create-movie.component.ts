import { Component, OnInit } from '@angular/core';
import { MovieForm } from '../model/movie';
import { Actor } from '../model/actor';
import { MovieService } from '../movie/movie.service';

@Component({
  selector: 'app-create-movie',
  templateUrl: './create-movie.component.html',
  styleUrls: ['./create-movie.component.css']
})
export class CreateMovieComponent implements OnInit {

  movieForm: MovieForm
  actors: Actor[]

  constructor(private movieService: MovieService) {
    //Not my proudest line of code..
    this.movieForm = new MovieForm(null,null,null,[],null,null,null,null,null,null,null,null,null);
    this.actors = [
      {name: "Arnold", country: null, dateOfBirth: null, careerStart: null},
      {name: "Tom", country: null, dateOfBirth: null, careerStart: null},
      {name: "Brat", country: null, dateOfBirth: null, careerStart: null}
    ]
  }

  ngOnInit() {
  }

  submit(){
    //Test
    console.log(this.movieForm);
    //this.movieService.save(this.movieForm);
  }
}
