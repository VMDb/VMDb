import { Component, OnInit, Input } from '@angular/core';
import { MovieForm } from '../model/movie';
import { MovieService } from '../movie/movie.service';
import { ActivatedRoute } from '@angular/router';
import { Genre } from '../model/genre';
import { Actor } from '../model/actor';
import { Writer } from '../model/writer';
import { Director } from '../model/director';
import { Producer } from '../model/producer';
import { Country } from '../model/country';

@Component({
  selector: 'app-update-movie',
  templateUrl: './update-movie.component.html',
  styleUrls: ['./update-movie.component.css']
})
export class UpdateMovieComponent implements OnInit {

  id: number;
  movieForm: MovieForm
  genres: Genre[]
  actors: Actor[]
  writers: Writer[]
  directors: Director[]
  producers: Producer[]
  countries: Country[]

  constructor(private movieService: MovieService, private route: ActivatedRoute) {
    this.route.params.subscribe(params => {
      this.id = params.id;
      this.movieService.getMovie(params.id).subscribe(movie => {
        this.movieForm = movie;
      });
    });

    this.genres = [
      {name: "Horror"},
      {name: "Comedy"},
      {name: "Action"},
      {name: "Sci-Fi"},
      {name: "Adventure"},
      {name: "Crime"},
      {name: "Drama"},
      {name: "Fantasy"},
      {name: "Historical"},
      {name: "Mystery"},
      {name: "Thriller"},
      {name: "Western"},
      {name: "Animation"},
    ]

    this.countries = [
      {name: "Bulgaria"},
      {name: "USA"},
      {name: "Russia"}
    ]

    movieService.getCrew("actor").subscribe(actorsIn => {
      this.actors = actorsIn as Actor[];
    });
    movieService.getCrew("writer").subscribe(writersIn => {
      this.writers = writersIn as Writer[];
    });
    movieService.getCrew("producer").subscribe(producersIn => {
      this.producers = producersIn as Producer[];
    });
    movieService.getCrew("director").subscribe(directorsIn => {
      this.directors = directorsIn as Director[];
    });
  }

  ngOnInit() {
  }

  submit(){
    //Test
    console.log(this.movieForm);
    //Doesn't work atm
    this.movieService.update(this.movieForm, this.id);
  }
}
