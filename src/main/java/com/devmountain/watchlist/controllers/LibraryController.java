package com.devmountain.watchlist.controllers;

import com.devmountain.watchlist.dtos.LibraryDto;
import com.devmountain.watchlist.entities.Library;
import com.devmountain.watchlist.repositories.LibraryRepository;
import com.devmountain.watchlist.services.LibraryServiceImpl;
import com.devmountain.watchlist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/home")
public class LibraryController {
    @Autowired
    LibraryRepository libraryRepository;
    @Autowired
    LibraryServiceImpl libraryService;
    @Autowired
    UserService userService;

    @PostMapping("{libraryId}/{movieId}")
        public void addMovie(@PathVariable Long libraryId, @PathVariable Long movieId){
        libraryService.addMovie(libraryId, movieId);
    }
    @PostMapping("/{userId}")
        public Optional<Long> addLibrary(@PathVariable Long userId){
        return Optional.of(libraryService.addLibrary(userId));

    }
    @GetMapping
        public List<LibraryDto> getAllLibraries(){
        return libraryService.getAllLibraries();
    }

    @GetMapping("/{userId}")
        public List<Library> getLibraryByUserId(@PathVariable Long userId){
        return libraryService.getLibraryByUserId(userId);
    }
    @DeleteMapping("/{libraryId}")
        public void deleteLibraryById(@PathVariable Long libraryId){
        libraryService.deleteLibraryById(libraryId);
    }
}
