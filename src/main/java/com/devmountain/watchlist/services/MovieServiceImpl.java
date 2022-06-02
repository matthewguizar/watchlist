package com.devmountain.watchlist.services;

import com.devmountain.watchlist.entities.Movie;
import com.devmountain.watchlist.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl {
@Autowired
    MovieRepository movieRepository;

public List<Movie> getAllMovies(){
    List<Movie> movieList = movieRepository.findAll();
    return movieList;
}
}
