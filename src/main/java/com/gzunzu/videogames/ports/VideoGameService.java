package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.dto.VideoGameDTO;

import java.time.LocalDate;
import java.util.List;

public interface VideoGameService {

    List<VideoGameDTO> getAll();

    VideoGameDTO getById(final Long id);

    List<VideoGameDTO> getByTitle(final String title);

    List<VideoGameDTO> getByReleaseYear(final int year);

    List<VideoGameDTO> getByGenre(final String genreName);

    List<VideoGameDTO> getByPlatform(final String platformName);

    List<VideoGameDTO> getByDeveloper(final String developerName);

    VideoGameDTO insert(final VideoGameDTO videoGameDTO);

    VideoGameDTO updateTitle(final Long id, final String title);

    VideoGameDTO updateReleaseDate(final Long id, final LocalDate releaseDate);

    VideoGameDTO updateEstimatedHours(final Long id, final float estimatedHours);

    VideoGameDTO updateMultiplayer(final Long id, final boolean multiplayer);

    VideoGameDTO updateGenres(final Long id, final String[] genreNames);

    VideoGameDTO updatePlatforms(final Long id, final String[] platformNames);

    VideoGameDTO updateDevelopers(final Long id, final String[] developerNames);

    boolean delete(final Long id);
}
