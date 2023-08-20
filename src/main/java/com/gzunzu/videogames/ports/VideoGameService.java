package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.model.VideoGame;

import java.util.List;

public interface VideoGameService {

    List<VideoGame> getAll();

    List<VideoGame> getByGenre(final String genre);
}
