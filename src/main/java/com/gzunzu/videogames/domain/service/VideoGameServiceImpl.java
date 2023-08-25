package com.gzunzu.videogames.domain.service;

import com.gzunzu.videogames.domain.model.VideoGame;
import com.gzunzu.videogames.ports.VideoGameRepository;
import com.gzunzu.videogames.ports.VideoGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoGameServiceImpl implements VideoGameService {

    private final VideoGameRepository videoGameRepository;

    @Override
    public List<VideoGame> getAll() {
        return this.videoGameRepository.findAll();
    }

    @Override
    public VideoGame getByTitle(final String title) {
        return this.videoGameRepository.findByTitle(title);
    }

    @Override
    public List<VideoGame> getByReleaseYear(final int year) {
        return this.videoGameRepository.findByReleaseYear(year);
    }
}
