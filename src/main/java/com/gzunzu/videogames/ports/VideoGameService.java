package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.dto.VideoGameDTO;

import java.util.List;

public interface VideoGameService {

    List<VideoGameDTO> getAll();

    VideoGameDTO getByTitle(final String title);

    List<VideoGameDTO> getByReleaseYear(final int year);

    List<VideoGameDTO> getByGenre(final String name);

    List<VideoGameDTO> getByPlatform(final String name);

    List<VideoGameDTO> getByDeveloper(final String name);
}
