import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '../../../../node_modules/@angular/router';
import { MovieForm } from '../model/movie';
import { MovieService } from '../movie/movie.service';

@Component({
  selector: 'app-view-movie',
  templateUrl: './view-movie.component.html',
  styleUrls: ['./view-movie.component.css']
})
export class ViewMovieComponent implements OnInit {

  movie: MovieForm;

  constructor(private route: ActivatedRoute, private movieService: MovieService) {
    this.route.params.subscribe(params => {
      this.movieService.getMovie(params.id).subscribe(mov => {
        this.movie = mov;
        var date = new Date(this.movie.releaseDate);
        this.movie.releaseDate = date;/*Required date copy and reassignment because JS*/
      });
    });
    
  }

  ngOnInit() {
  }

}
