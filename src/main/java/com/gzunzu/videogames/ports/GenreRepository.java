package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    Optional<Genre> findByNameEqualsIgnoreCase(final String name);
}
