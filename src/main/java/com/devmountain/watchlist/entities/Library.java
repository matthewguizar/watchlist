package com.devmountain.watchlist.entities;

import com.devmountain.watchlist.dtos.LibraryDto;
import com.devmountain.watchlist.dtos.MovieDto;
import com.devmountain.watchlist.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@Table(name = "Libraries")
@AllArgsConstructor
@NoArgsConstructor
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "movie")
    private MovieDto movie;
    @Column(name = "watched")
    private Boolean watched;
    @ManyToOne
    @JsonBackReference
    private User user;

    public Library(LibraryDto libraryDto) {
        this.id = libraryDto.getId();
        this.movie = libraryDto.getMovieDto();
        this.watched = libraryDto.isWatched();
        this.user = libraryDto.getUser();

    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", movie=" + movie +
                ", watched=" + watched +
                ", user=" + user +
                '}';
    }
}
