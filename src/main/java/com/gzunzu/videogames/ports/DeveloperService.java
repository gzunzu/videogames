package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.dto.DeveloperDTO;

import java.util.List;

public interface DeveloperService {

    List<DeveloperDTO> getAll();

    DeveloperDTO getById(final long id);

    DeveloperDTO getByName(final String name);

    DeveloperDTO insert(final DeveloperDTO developerDTO);

    DeveloperDTO update(final DeveloperDTO developerDTO);

    boolean delete(final Long id);
}
