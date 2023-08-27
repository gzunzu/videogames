package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.dto.PlatformDTO;

import java.util.List;

public interface PlatformService {

    List<PlatformDTO> getAll();

    PlatformDTO getById(final long id);

    PlatformDTO getByName(final String name);

    PlatformDTO insert(final PlatformDTO platformDTO);

    PlatformDTO update(final PlatformDTO platformDTO);

    boolean delete(final Long id);
}
