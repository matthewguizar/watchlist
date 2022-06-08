package com.devmountain.watchlist.entities;

import com.devmountain.watchlist.dtos.MovieDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(name= "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "overview")
    private String overview;
    @Column(name = "title")
    private String title;
    @Column(name = "poster_path")
    private String posterPath;
    @Column(name = "backdrop_path")
    private String backdropPath;
    @Column(name = "release_date")
    private String releaseDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Movie(MovieDto movieDto) {
       this.id = movieDto.getId();
       this.overview = movieDto.getOverview();
       this.title = movieDto.getTitle();
       this.posterPath = movieDto.getPosterPath();
       this.backdropPath = movieDto.getBackdropPath();
       this.releaseDate = movieDto.getReleaseDate();
    }


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", overview='" + overview + '\'' +
                ", title='" + title + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", backdropPath='" + backdropPath + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }

}
