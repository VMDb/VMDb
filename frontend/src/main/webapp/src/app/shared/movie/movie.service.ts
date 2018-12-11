import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/observable';
import { Movie } from '../movie-list/movie';

@Injectable()
export class MovieService {

  private http:HttpClient;

  constructor(http: HttpClient) {
    this.http = http;
  }

  getAll(): Observable<Movie[]> {
    return this.http.get<Movie[]>("http://localhost:8080/home");
  }
}