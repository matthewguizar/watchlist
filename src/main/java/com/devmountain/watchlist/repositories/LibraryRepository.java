package com.devmountain.watchlist.repositories;

import com.devmountain.watchlist.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
    List<Library> findLibraryByUserId(Long userId);

    boolean isWatched(Library library);
}
