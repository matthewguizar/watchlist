package com.devmountain.watchlist.dtos;

import com.devmountain.watchlist.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto implements Serializable {
    private Long id;
    private String overview;
    private String title;
    private String posterPath;
    private String backdropPath;
    private String releaseDate;

    public MovieDto(Movie movie){
        this.id = movie.getId();
        this.overview = movie.getOverview();
        this.title = movie.getTitle();
        this.posterPath = movie.getPosterPath();
        this.backdropPath = movie.getBackdropPath();
        this.releaseDate = movie.getReleaseDate();
    }

}
