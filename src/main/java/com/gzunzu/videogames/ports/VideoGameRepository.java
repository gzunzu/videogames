package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.model.VideoGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame, Long> {

    VideoGame findByTitle(final String title);

    @Query("SELECT v FROM VideoGame v WHERE YEAR(v.releaseDate) = :year")
    List<VideoGame> findByReleaseYear(@Param("year") final int year);
}
