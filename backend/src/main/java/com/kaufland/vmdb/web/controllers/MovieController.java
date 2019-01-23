package com.kaufland.vmdb.web.controllers;

import com.kaufland.vmdb.domain.Movie;
import com.kaufland.vmdb.dto.MovieDTO;
import com.kaufland.vmdb.service.CommentService;
import com.kaufland.vmdb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {

    private MovieService movieService;

    private CommentService commentService;

    @Autowired
    public MovieController(MovieService movieService, CommentService commentService) {
        this.movieService = movieService;
        this.commentService = commentService;
    }

    @RequestMapping(value = "/save-movie",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity saveMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return ResponseEntity.ok("Movie Saved!");
    }

    @RequestMapping(value = "/home",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<MovieDTO> greeting() {
        return movieService.allInTheaters();
    }

    @GetMapping("/movies/{id}")
    public String getMovie(@PathVariable Long id, Model model){
        Movie movie = movieService.getByID(id);
        model.addAttribute("movie", movie);
        model.addAttribute("comments", commentService.getByMovie(movie, 0));
        return "view_movie";
    }
}
