import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/observable'

@Injectable()
export class MovieService {

  private http:HttpClient;

  constructor(http: HttpClient) {
    this.http = http;
  }

  getAll(): Observable<any> {
    return this.http.get('//localhost:8080/home');
  }
}