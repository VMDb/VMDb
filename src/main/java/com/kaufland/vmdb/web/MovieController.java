package com.kaufland.vmdb.web;

import com.kaufland.vmdb.dto.MovieDTO;
import com.kaufland.vmdb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MovieController {

    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public String greeting(Model model) {
        List<MovieDTO> movies = movieService.allInTheaters();
        model.addAttribute("movies", movies);
        return "index";
    }
}
