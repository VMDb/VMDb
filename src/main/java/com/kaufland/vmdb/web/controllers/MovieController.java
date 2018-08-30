package com.kaufland.vmdb.web.controllers;

import com.kaufland.vmdb.domain.Movie;
import com.kaufland.vmdb.dto.MovieDTO;
import com.kaufland.vmdb.service.CommentService;
import com.kaufland.vmdb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MovieController {

    private MovieService movieService;

    private CommentService commentService;

    @Autowired
    public MovieController(MovieService movieService, CommentService commentService) {
        this.movieService = movieService;
        this.commentService = commentService;
    }

    @GetMapping("/")
    public String greeting(Model model) {
        List<MovieDTO> movies = movieService.allInTheaters();
        model.addAttribute("movies", movies);
        return "index";
    }

    @GetMapping("/movies/{id}")
    public String getMovie(@PathVariable Long id, Model model){
        Movie movie = movieService.getByID(id);
        model.addAttribute("movie", movie);
        model.addAttribute("comments", commentService.getByMovie(movie, 0));
        return "view_movie";
    }
}
