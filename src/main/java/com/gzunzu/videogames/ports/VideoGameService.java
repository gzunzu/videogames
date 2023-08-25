package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.model.VideoGame;

import java.util.List;

public interface VideoGameService {

    List<VideoGame> getAll();

    VideoGame getByTitle(final String title);

    List<VideoGame> getByReleaseYear(final int year);
}
