package com.gzunzu.videogames.domain.service;

import com.gzunzu.videogames.domain.dto.NominationDTO;
import com.gzunzu.videogames.domain.dto.VideoGameDTO;
import com.gzunzu.videogames.domain.mapper.VideoGameMapper;
import com.gzunzu.videogames.domain.model.Developer;
import com.gzunzu.videogames.domain.model.Genre;
import com.gzunzu.videogames.domain.model.Platform;
import com.gzunzu.videogames.domain.model.VideoGame;
import com.gzunzu.videogames.ports.DeveloperRepository;
import com.gzunzu.videogames.ports.GenreRepository;
import com.gzunzu.videogames.ports.NominationService;
import com.gzunzu.videogames.ports.PlatformRepository;
import com.gzunzu.videogames.ports.VideoGameRepository;
import com.gzunzu.videogames.ports.VideoGameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class VideoGameServiceImpl implements VideoGameService {

    private final VideoGameRepository videoGameRepository;
    private final GenreRepository genreRepository;
    private final PlatformRepository platformRepository;
    private final DeveloperRepository developerRepository;
    private final NominationService nominationService;
    private final VideoGameMapper videoGameMapper;

    @Override
    public List<VideoGameDTO> getAll() {
        List<VideoGame> videoGames = this.videoGameRepository.findAll();

        return this.videoGameMapper.toDto().apply(videoGames);
    }

    @Override
    public VideoGameDTO getById(final Long id) {
        final VideoGame videoGame = this.videoGameRepository.findById(id)
                .orElse(null);

        return this.videoGameMapper.toDto(videoGame);
    }

    @Override
    public List<VideoGameDTO> getByTitle(final String title) {
        final List<VideoGame> videoGames = this.videoGameRepository.findByTitleContainsIgnoreCase(title);

        return this.videoGameMapper.toDto().apply(videoGames);
    }

    @Override
    public List<VideoGameDTO> getByReleaseYear(final int year) {
        final List<VideoGame> videoGames = this.videoGameRepository.findByReleaseYear(year);

        return this.videoGameMapper.toDto().apply(videoGames);
    }

    @Override
    public List<VideoGameDTO> getByGenre(final String genreName) {
        final Optional<Genre> genre = this.genreRepository.findByNameEqualsIgnoreCase(genreName);
        final List<VideoGame> videoGames = genre.map(this.videoGameRepository::findByGenresContains)
                .orElse(Collections.emptyList());

        return this.videoGameMapper.toDto().apply(videoGames);
    }

    @Override
    public List<VideoGameDTO> getByPlatform(final String platformName) {
        final Optional<Platform> platform = this.platformRepository.findByNameEqualsIgnoreCase(platformName);
        final List<VideoGame> videoGames = platform.map(this.videoGameRepository::findByPlatformsContains)
                .orElse(Collections.emptyList());

        return this.videoGameMapper.toDto().apply(videoGames);
    }

    @Override
    public List<VideoGameDTO> getByDeveloper(final String developerName) {
        final Optional<Developer> developer = this.developerRepository.findByNameEqualsIgnoreCase(developerName);
        final List<VideoGame> videoGames = developer.map(this.videoGameRepository::findByDevelopersContains)
                .orElse(Collections.emptyList());

        return this.videoGameMapper.toDto().apply(videoGames);
    }

    @Override
    public VideoGameDTO insert(final VideoGameDTO videoGameDTO) {
        final VideoGame videoGame = this.videoGameMapper.fromDto(videoGameDTO);
        final VideoGame savedVideoGame = this.videoGameRepository.save(videoGame);
        CollectionUtils.emptyIfNull(videoGameDTO.getNominations())
                .forEach((NominationDTO nominationDTO) -> {
                    nominationDTO.setVideoGameId(savedVideoGame.getId());
                    this.nominationService.insert(nominationDTO);
                });

        final VideoGame result = this.videoGameRepository.findById(savedVideoGame.getId())
                .orElse(null);

        return this.videoGameMapper.toDto(result);
    }

    @Override
    public VideoGameDTO updateTitle(final Long id, final String title) {
        final Optional<VideoGame> videoGameOpt = this.videoGameRepository.findById(id);
        if (videoGameOpt.isPresent()) {
            final VideoGame videoGame = videoGameOpt.get();
            videoGame.setTitle(title);
            final VideoGame result = this.videoGameRepository.save(videoGame);
            return this.videoGameMapper.toDto(result);
        } else {
            log.info("No video game with id {} found to update title.", id);
            return null;
        }
    }

    @Override
    public VideoGameDTO updateReleaseDate(final Long id, final LocalDate releaseDate) {
        final Optional<VideoGame> videoGameOpt = this.videoGameRepository.findById(id);
        if (videoGameOpt.isPresent()) {
            final VideoGame videoGame = videoGameOpt.get();
            videoGame.setReleaseDate(releaseDate);
            final VideoGame result = this.videoGameRepository.save(videoGame);
            return this.videoGameMapper.toDto(result);
        } else {
            log.info("No video game with id {} found to update release date.", id);
            return null;
        }
    }

    @Override
    public VideoGameDTO updateEstimatedHours(final Long id, final float estimatedHours) {
        final Optional<VideoGame> videoGameOpt = this.videoGameRepository.findById(id);
        if (videoGameOpt.isPresent()) {
            final VideoGame videoGame = videoGameOpt.get();
            videoGame.setEstimatedHours(estimatedHours);
            final VideoGame result = this.videoGameRepository.save(videoGame);
            return this.videoGameMapper.toDto(result);
        } else {
            log.info("No video game with id {} found to update estimated hours.", id);
            return null;
        }
    }

    @Override
    public VideoGameDTO updateMultiplayer(final Long id, final boolean multiplayer) {
        final Optional<VideoGame> videoGameOpt = this.videoGameRepository.findById(id);
        if (videoGameOpt.isPresent()) {
            final VideoGame videoGame = videoGameOpt.get();
            videoGame.setMultiplayer(multiplayer);
            final VideoGame result = this.videoGameRepository.save(videoGame);
            return this.videoGameMapper.toDto(result);
        } else {
            log.info("No video game with id {} found to update multiplayer attribute.", id);
            return null;
        }
    }

    @Override
    public VideoGameDTO updateGenres(final Long id, final String[] genreNames) {
        final Optional<VideoGame> videoGameOpt = this.videoGameRepository.findById(id);
        if (videoGameOpt.isPresent()) {
            final List<Genre> genres = Arrays.stream(genreNames)
                    .map(this.genreRepository::findByNameEqualsIgnoreCase)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
            final VideoGame videoGame = videoGameOpt.get();
            videoGame.setGenres(genres);

            final VideoGame result = this.videoGameRepository.save(videoGame);
            return this.videoGameMapper.toDto(result);
        } else {
            log.info("No video game with id {} found to update genres.", id);
            return null;
        }
    }

    @Override
    public VideoGameDTO updatePlatforms(final Long id, final String[] platformNames) {
        final Optional<VideoGame> videoGameOpt = this.videoGameRepository.findById(id);
        if (videoGameOpt.isPresent()) {
            final List<Platform> platforms = Arrays.stream(platformNames)
                    .map(this.platformRepository::findByNameEqualsIgnoreCase)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
            final VideoGame videoGame = videoGameOpt.get();
            videoGame.setPlatforms(platforms);

            final VideoGame result = this.videoGameRepository.save(videoGame);
            return this.videoGameMapper.toDto(result);
        } else {
            log.info("No video game with id {} found to update platforms.", id);
            return null;
        }
    }

    @Override
    public VideoGameDTO updateDevelopers(final Long id, final String[] developerNames) {
        final Optional<VideoGame> videoGameOpt = this.videoGameRepository.findById(id);
        if (videoGameOpt.isPresent()) {
            final List<Developer> developers = Arrays.stream(developerNames)
                    .map(this.developerRepository::findByNameEqualsIgnoreCase)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
            final VideoGame videoGame = videoGameOpt.get();
            videoGame.setDevelopers(developers);

            final VideoGame result = this.videoGameRepository.save(videoGame);
            return this.videoGameMapper.toDto(result);
        } else {
            log.info("No video game with id {} found to update developers.", id);
            return null;
        }
    }

    @Override
    public boolean delete(final Long id) {
        if (this.videoGameRepository.existsById(id)) {
            this.nominationService.deleteByVideoGameId(id);
            this.videoGameRepository.deleteById(id);
            return !this.videoGameRepository.existsById(id);
        } else {
            log.info("No video game with ID {} found to delete.", id);
            return false;
        }
    }
}
