package com.gzunzu.videogames.domain.service;

import com.gzunzu.videogames.domain.model.Genre;
import com.gzunzu.videogames.domain.model.VideoGame;
import com.gzunzu.videogames.ports.VideoGameRepository;
import com.gzunzu.videogames.ports.VideoGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VideoGameServiceImpl implements VideoGameService {

    private final VideoGameRepository videoGameRepository;

    @Override
    public List<VideoGame> getAll() {
        return this.videoGameRepository.findAll();
    }

    @Override
    public List<VideoGame> getByGenre(final String genre) {
        final List<VideoGame> videogameList = this.videoGameRepository.findAll();
        return videogameList.stream()
                .filter((VideoGame vg) -> vg.getGenres().stream()
                        .map(Genre::getName)
                        .anyMatch(genre::equalsIgnoreCase))
                .collect(Collectors.toList());
    }
}
