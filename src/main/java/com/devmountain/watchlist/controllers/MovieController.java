package com.devmountain.watchlist.controllers;
import com.devmountain.watchlist.entities.Movie;
import com.devmountain.watchlist.services.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/home")
public class MovieController {
    @Autowired
    MovieServiceImpl movieService;

    @GetMapping("movies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }
}
