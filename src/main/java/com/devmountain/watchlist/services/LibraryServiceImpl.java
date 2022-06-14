package com.devmountain.watchlist.services;

import com.devmountain.watchlist.dtos.LibraryDto;
import com.devmountain.watchlist.dtos.MovieDto;
import com.devmountain.watchlist.entities.Library;
import com.devmountain.watchlist.entities.Movie;
import com.devmountain.watchlist.entities.User;
import com.devmountain.watchlist.repositories.LibraryRepository;
import com.devmountain.watchlist.repositories.MovieRepository;
import com.devmountain.watchlist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibraryServiceImpl {
    @Autowired
    LibraryRepository libraryRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    UserRepository userRepository;

    @Transactional
    public Long addLibrary(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        Library library = new Library();
        library.setUser(userRepository.getReferenceById(userId));
        libraryRepository.saveAndFlush(library);
        System.out.println("library added");
        Long libraryId = library.getId();
        return libraryId;

    }
    @Transactional
    public String addMovie(Long libraryId,Long movieId){
        Optional<Movie> movieOptional = movieRepository.findById(movieId);
        Optional<Library> libraryOptional = libraryRepository.findById(libraryId);

        if (movieOptional.isPresent() && libraryOptional.isPresent()){
            libraryOptional.get().setMovie(new MovieDto(movieOptional.get()));
            System.out.println("Library Option.get: " + libraryOptional.get());
            System.out.println("Library Id: " + libraryId);
            libraryRepository.saveAndFlush(libraryOptional.get());
            System.out.println("movie and library present");

            return "Movie added";
        }
        return "Movie not added";
    }
    public List<LibraryDto> getAllLibraries(){
        List<Library> libraryList = libraryRepository.findAll();
        return libraryList.stream().map(library -> new LibraryDto(library)).collect(Collectors.toList());
    }
    public Optional<Library> getLibrary(Long libraryId){
        Optional<Library> libraryList = libraryRepository.findById(libraryId);
        return libraryList;
    }

    public List<Library> getLibraryByUserId(Long userId) {
        List<Library> libraryList = libraryRepository.findLibraryByUserId(userId);
        return libraryList;
    }
    @Transactional
    public void deleteLibraryById(Long libraryId){
        Optional<Library> libraryOptional = libraryRepository.findById(libraryId);
        libraryOptional.ifPresent(library -> libraryRepository.delete(library));
    }
}

