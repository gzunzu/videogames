package com.gzunzu.videogames.domain.mapper.impl;

import com.gzunzu.videogames.domain.dto.GenreDTO;
import com.gzunzu.videogames.domain.mapper.GenreMapper;
import com.gzunzu.videogames.domain.model.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GenreMapperImpl implements GenreMapper {

    @Override
    public GenreDTO toDto(final Genre genre) {
        if (genre == null) {
            return null;
        }

        return GenreDTO.builder()
                .id(genre.getId())
                .name(genre.getName())
                .build();
    }

    @Override
    public Genre fromDto(final GenreDTO genreDTO) {
        if (genreDTO == null) {
            return null;
        }

        return Genre.builder()
                .id(genreDTO.getId())
                .name(genreDTO.getName())
                .build();
    }
}
