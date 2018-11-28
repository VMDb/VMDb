package com.kaufland.vmdb.web.controllers;

import com.kaufland.vmdb.domain.Movie;
import com.kaufland.vmdb.dto.MovieDTO;
import com.kaufland.vmdb.service.CommentService;
import com.kaufland.vmdb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    private MovieService movieService;

    private CommentService commentService;

    @Autowired
    public MovieController(MovieService movieService, CommentService commentService) {
        this.movieService = movieService;
        this.commentService = commentService;
    }

    @GetMapping("/home")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<MovieDTO> greeting(Model model) {
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
