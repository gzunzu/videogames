package com.gzunzu.videogames.domain.mapper.impl;

import com.gzunzu.videogames.domain.dto.NominationDTO;
import com.gzunzu.videogames.domain.dto.VideoGameDTO;
import com.gzunzu.videogames.domain.mapper.NominationMapper;
import com.gzunzu.videogames.domain.mapper.VideoGameMapper;
import com.gzunzu.videogames.domain.model.Developer;
import com.gzunzu.videogames.domain.model.Genre;
import com.gzunzu.videogames.domain.model.Nomination;
import com.gzunzu.videogames.domain.model.Platform;
import com.gzunzu.videogames.domain.model.VideoGame;
import com.gzunzu.videogames.ports.DeveloperRepository;
import com.gzunzu.videogames.ports.GenreRepository;
import com.gzunzu.videogames.ports.PlatformRepository;
import com.gzunzu.videogames.ports.VideoGameRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class VideoGameMapperImpl implements VideoGameMapper {

    private final NominationMapper nominationMapper;
    private final VideoGameRepository videoGameRepository;
    private final GenreRepository genreRepository;
    private final PlatformRepository platformRepository;
    private final DeveloperRepository developerRepository;

    @Override
    public VideoGameDTO toDto(final VideoGame videoGame) {
        if (videoGame == null) {
            return null;
        }

        final List<String> genres = CollectionUtils.emptyIfNull(videoGame.getGenres()).stream()
                .map(Genre::getName)
                .collect(Collectors.toList());

        final List<String> developers = CollectionUtils.emptyIfNull(videoGame.getDevelopers()).stream()
                .map(Developer::getName)
                .collect(Collectors.toList());

        final List<String> platforms = CollectionUtils.emptyIfNull(videoGame.getPlatforms()).stream()
                .map(Platform::getName)
                .collect(Collectors.toList());

        final List<NominationDTO> nominations = CollectionUtils.emptyIfNull(videoGame.getNominations()).stream()
                .map(this.nominationMapper::toDto)
                .collect(Collectors.toList());

        return VideoGameDTO.builder()
                .id(videoGame.getId())
                .title(videoGame.getTitle())
                .releaseDate(videoGame.getReleaseDate())
                .estimatedHours(videoGame.getEstimatedHours())
                .multiplayer(videoGame.isMultiplayer())
                .genres(genres)
                .nominations(nominations)
                .developers(developers)
                .platforms(platforms)
                .build();
    }

    @Override
    public VideoGame fromDto(final VideoGameDTO videoGameDTO) {
        if (videoGameDTO == null) {
            return null;
        }

        final Long id = videoGameDTO.getId() != null ? videoGameDTO.getId() :
                this.videoGameRepository.findByTitleContainsIgnoreCase(videoGameDTO.getTitle()).stream()
                        .filter((VideoGame videoGame) -> videoGame.getReleaseDate().equals(videoGameDTO.getReleaseDate()))
                        .map(VideoGame::getId)
                        .findAny()
                        .orElse(null);

        final List<Genre> genres = CollectionUtils.emptyIfNull(videoGameDTO.getGenres()).stream()
                .map(this.genreRepository::findByNameEqualsIgnoreCase)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        final List<Developer> developers = CollectionUtils.emptyIfNull(videoGameDTO.getDevelopers()).stream()
                .map(this.developerRepository::findByNameEqualsIgnoreCase)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        final List<Platform> platforms = CollectionUtils.emptyIfNull(videoGameDTO.getPlatforms()).stream()
                .map(this.platformRepository::findByNameEqualsIgnoreCase)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        final List<Nomination> nominations = CollectionUtils.emptyIfNull(videoGameDTO.getNominations()).stream()
                .map(this.nominationMapper::fromDto)
                .filter(Objects::nonNull)
                .peek((Nomination nomination) -> {
                    if (nomination.getVideoGame() == null || nomination.getVideoGame().getId() == null) {
                        nomination.setVideoGame(VideoGame.builder().id(id).build());
                    }
                })
                .collect(Collectors.toList());

        return VideoGame.builder()
                .id(id)
                .title(videoGameDTO.getTitle())
                .releaseDate(videoGameDTO.getReleaseDate())
                .estimatedHours(videoGameDTO.getEstimatedHours())
                .multiplayer(videoGameDTO.isMultiplayer())
                .genres(genres)
                .nominations(nominations)
                .developers(developers)
                .platforms(platforms)
                .build();
    }
}
