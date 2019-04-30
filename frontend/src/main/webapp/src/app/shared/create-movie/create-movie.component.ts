import { Component, OnInit } from '@angular/core';
import { MovieForm } from '../model/movie';
import { Genre } from '../model/genre';
import { Actor } from '../model/actor';
import { Writer } from '../model/writer';
import { Director } from '../model/director';
import { Producer } from '../model/producer';
import { Country } from '../model/country';
import { MovieService } from '../movie/movie.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-create-movie',
  templateUrl: './create-movie.component.html',
  styleUrls: ['./create-movie.component.css']
})
export class CreateMovieComponent implements OnInit {

  id: number;
  movieForm: MovieForm
  genres: Genre[]
  actors: Actor[]
  writers: Writer[]
  directors: Director[]
  producers: Producer[]
  countries: Country[]

  constructor(private movieService: MovieService, private route: ActivatedRoute) {
    this.movieForm = new MovieForm();
    this.id = null;
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

    this.actors = [
      {name: "Arnold", country: null, dateOfBirth: null, careerStart: null},
      {name: "Tom", country: null, dateOfBirth: null, careerStart: null},
      {name: "Brat", country: null, dateOfBirth: null, careerStart: null}
    ]

    this.writers = [
      {name: "John", country: null, dateOfBirth: null, careerStart: null},
      {name: "Peter", country: null, dateOfBirth: null, careerStart: null},
      {name: "Ivan", country: null, dateOfBirth: null, careerStart: null}
    ]

    this.directors = [
      {name: "Ryan", country: null, dateOfBirth: null, careerStart: null},
      {name: "JJ Abrams", country: null, dateOfBirth: null, careerStart: null},
      {name: "Stefan", country: null, dateOfBirth: null, careerStart: null}
    ]

    this.producers = [
      {name: "Leo", country: null, dateOfBirth: null, careerStart: null},
      {name: "George", country: null, dateOfBirth: null, careerStart: null},
      {name: "Michael", country: null, dateOfBirth: null, careerStart: null}
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
    
    if(this.id !== undefined){
      console.log("update :: "+this.id)
      this.movieService.update(this.movieForm, this.id);
    }else{
      console.log("update")
      this.movieService.save(this.movieForm);
    }
  }
}
