package com.gzunzu.videogames.domain.service;

import com.gzunzu.videogames.domain.dto.VideoGameDTO;
import com.gzunzu.videogames.domain.mapper.VideoGameMapper;
import com.gzunzu.videogames.domain.model.Developer;
import com.gzunzu.videogames.domain.model.Genre;
import com.gzunzu.videogames.domain.model.Platform;
import com.gzunzu.videogames.domain.model.VideoGame;
import com.gzunzu.videogames.ports.DeveloperRepository;
import com.gzunzu.videogames.ports.GenreRepository;
import com.gzunzu.videogames.ports.PlatformRepository;
import com.gzunzu.videogames.ports.VideoGameRepository;
import com.gzunzu.videogames.ports.VideoGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoGameServiceImpl implements VideoGameService {

    private final VideoGameRepository videoGameRepository;
    private final GenreRepository genreRepository;
    private final PlatformRepository platformRepository;
    private final DeveloperRepository developerRepository;
    private final VideoGameMapper videoGameMapper;

    @Override
    public List<VideoGameDTO> getAll() {
        List<VideoGame> videoGames = this.videoGameRepository.findAll();

        return this.videoGameMapper.toDto().apply(videoGames);
    }

    @Override
    public VideoGameDTO getByTitle(final String title) {
        final VideoGame videoGame = this.videoGameRepository.findByTitleContainsIgnoreCase(title);

        return this.videoGameMapper.toDto(videoGame);
    }

    @Override
    public List<VideoGameDTO> getByReleaseYear(final int year) {
        final List<VideoGame> videoGames = this.videoGameRepository.findByReleaseYear(year);

        return this.videoGameMapper.toDto().apply(videoGames);
    }

    @Override
    public List<VideoGameDTO> getByGenre(final String name) {
        final Genre genre = this.genreRepository.findByNameEqualsIgnoreCase(name);
        final List<VideoGame> videoGames = this.videoGameRepository.findByGenresContains(genre);

        return this.videoGameMapper.toDto().apply(videoGames);
    }

    @Override
    public List<VideoGameDTO> getByPlatform(final String name) {
        final Platform platform = this.platformRepository.findByNameEqualsIgnoreCase(name);
        final List<VideoGame> videoGames = this.videoGameRepository.findByPlatformsContains(platform);

        return this.videoGameMapper.toDto().apply(videoGames);
    }

    @Override
    public List<VideoGameDTO> getByDeveloper(final String name) {
        final Developer developer = this.developerRepository.findByNameEqualsIgnoreCase(name);
        List<VideoGame> videoGames = this.videoGameRepository.findByDevelopersContains(developer);

        return this.videoGameMapper.toDto().apply(videoGames);
    }
}
