import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Movie } from '../movie-list/movie';
import { MovieForm } from '../model/movie';
import { Human } from '../model/human';

@Injectable()
export class MovieService {

  private http:HttpClient;

  constructor(http: HttpClient) {
    this.http = http;
  }

  save(movieForm: MovieForm){
    console.log("here")
    //doesn't work atm
    this.http.post("http://localhost:8080/movies", movieForm).subscribe();
  }

  update(movieForm: MovieForm, id: number){
    this.http.put("http://localhost:8080/movies?id="+id, movieForm).subscribe();
  }

  getCrew(roleParam: string): Observable<Human[]>{
    return this.http.get<Human[]>("http://localhost:8080/crew",{
      params: {
        role: roleParam
      }});
  }

  getAll(): Observable<Movie[]> {
    // TODO: The endpoint should be /movies. Check this https://restfulapi.net/resource-naming/
    return this.http.get<Movie[]>("http://localhost:8080/movies");
  }

  getMovie(id: number): Observable<MovieForm>{
    return this.http.get<MovieForm>("http://localhost:8080/movies/"+id);
  }
}
