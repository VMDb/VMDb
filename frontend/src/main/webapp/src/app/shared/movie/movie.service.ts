import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Movie } from '../movie-list/movie';
import { MovieForm } from '../model/movie';

@Injectable()
export class MovieService {

  private http:HttpClient;

  constructor(http: HttpClient) {
    this.http = http;
  }

  save(movieForm: MovieForm){
    console.log("here")
    //doesn't work atm
    this.http.post("http://localhost:8080/save-movie", movieForm).subscribe();
  }

  getAll(): Observable<Movie[]> {
    // TODO: The endpoint should be /movies. Check this https://restfulapi.net/resource-naming/
    return this.http.get<Movie[]>("http://localhost:8080/home");
  }
}
