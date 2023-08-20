package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.model.VideoGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame, Long> {
}
