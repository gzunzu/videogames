package com.gzunzu.videogames.domain.service;

import com.gzunzu.videogames.domain.dto.GenreDTO;
import com.gzunzu.videogames.domain.mapper.GenreMapper;
import com.gzunzu.videogames.domain.model.Genre;
import com.gzunzu.videogames.ports.GenreRepository;
import com.gzunzu.videogames.ports.GenreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GenreServiceImpl implements GenreService {

    final GenreRepository genreRepository;
    final GenreMapper genreMapper;

    @Override
    public List<GenreDTO> getAll() {
        final List<Genre> genres = this.genreRepository.findAll();

        return this.genreMapper.toDto().apply(genres);
    }

    @Override
    public GenreDTO getById(final long id) {
        final Genre genre = this.genreRepository.findById(id)
                .orElse(null);

        return this.genreMapper.toDto(genre);
    }

    @Override
    public GenreDTO getByName(final String name) {
        final Genre genre = this.genreRepository.findByNameEqualsIgnoreCase(name);

        return this.genreMapper.toDto(genre);
    }

    @Override
    public GenreDTO insert(final GenreDTO genreDTO) {
        final Genre genre = this.genreMapper.fromDto(genreDTO);
        final Genre result = this.genreRepository.save(genre);

        return this.genreMapper.toDto(result);
    }

    @Override
    public GenreDTO update(final GenreDTO genreDTO) {
        final Genre genre = this.genreMapper.fromDto(genreDTO);
        final Genre result = this.genreRepository.save(genre);

        return this.genreMapper.toDto(result);
    }

    @Override
    public boolean delete(final Long id) {
        if (this.genreRepository.existsById(id)) {
            this.genreRepository.deleteById(id);
            return !this.genreRepository.existsById(id);
        } else {
            log.info("No genre with ID {} found to delete.", id);
            return false;
        }
    }
}
