package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.dto.GenreDTO;

import java.util.List;

public interface GenreService {

    List<GenreDTO> getAll();

    GenreDTO getById(final long id);

    GenreDTO getByName(final String name);

    GenreDTO insert(final GenreDTO genreDTO);

    GenreDTO update(final GenreDTO genreDTO);

    boolean delete(final Long id);
}
