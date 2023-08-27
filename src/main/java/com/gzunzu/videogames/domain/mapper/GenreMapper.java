package com.gzunzu.videogames.domain.mapper;

import com.gzunzu.common.domain.mapper.ModelMapper;
import com.gzunzu.videogames.domain.dto.GenreDTO;
import com.gzunzu.videogames.domain.model.Genre;

public interface GenreMapper extends ModelMapper<Genre, GenreDTO> {

    @Override
    GenreDTO toDto(final Genre genre);

    @Override
    Genre fromDto(final GenreDTO genreDTO);
}
