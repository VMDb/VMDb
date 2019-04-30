package com.kaufland.vmdb.web.controllers;

import com.kaufland.vmdb.domain.Movie;
import com.kaufland.vmdb.dto.MovieDTO;
import com.kaufland.vmdb.request.MovieModel;
import com.kaufland.vmdb.service.CommentService;
import com.kaufland.vmdb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {

    private final MovieService movieService;

    private final CommentService commentService;

    @Autowired
    public MovieController(MovieService movieService, CommentService commentService) {
        this.movieService = movieService;
        this.commentService = commentService;
    }

    @PostMapping(value = "/movies",
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity saveMovie(@RequestBody MovieModel movie) {
        movieService.addMovie(movie);
        return ResponseEntity.created(URI.create("/movies/" + movie.getId())).body(movie);
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity updateMovie(@RequestBody MovieModel model, @PathVariable(name = "id") Integer movieId){
        movieService.updateMovie(model, movieId);
        return ResponseEntity.ok(model);
    }

    @GetMapping(value = "/movies",
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MovieDTO> greeting() {
        return movieService.allInTheaters();
    }

//    @GetMapping("/movies/{id}")
//    public String getMovie(@PathVariable Long id, Model model){
//        Movie movie = movieService.getByID(id);
//        model.addAttribute("movie", movie);
//        model.addAttribute("comments", commentService.getByMovie(movie, 0));
//        return "view_movie";
//    }

    @GetMapping(value = "/movies/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie getMovie(@PathVariable Long id) {
        return movieService.getByID(id);
    }
}
