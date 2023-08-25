package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    Genre findByNameEqualsIgnoreCase(final String name);
}
