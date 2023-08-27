package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.model.Developer;
import com.gzunzu.videogames.domain.model.Genre;
import com.gzunzu.videogames.domain.model.Platform;
import com.gzunzu.videogames.domain.model.VideoGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame, Long> {

    List<VideoGame> findByTitleContainsIgnoreCase(final String title);

    @Query("SELECT v FROM VideoGame v WHERE YEAR(v.releaseDate) = :year")
    List<VideoGame> findByReleaseYear(@Param("year") final int year);

    List<VideoGame> findByGenresContains(final Genre genre);

    List<VideoGame> findByPlatformsContains(final Platform platform);

    List<VideoGame> findByDevelopersContains(final Developer developer);
}
