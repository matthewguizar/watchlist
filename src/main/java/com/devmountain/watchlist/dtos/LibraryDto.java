package com.devmountain.watchlist.dtos;


import com.devmountain.watchlist.entities.Library;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryDto implements Serializable {

    private Long id;
    private MovieDto movieDto;

    private Boolean watched;
    private UserDto user;

    public LibraryDto(Library library) {
        this.id = library.getId();
        this.movieDto = library.getMovie();
        this.watched = library.isWatched();

    }
}
