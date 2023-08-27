package com.gzunzu.videogames.domain.mapper;

import com.gzunzu.common.domain.mapper.ModelMapper;
import com.gzunzu.videogames.domain.dto.DeveloperDTO;
import com.gzunzu.videogames.domain.model.Developer;

public interface DeveloperMapper extends ModelMapper<Developer, DeveloperDTO> {

    @Override
    DeveloperDTO toDto(final Developer developer);

    @Override
    Developer fromDto(final DeveloperDTO developerDTO);
}
