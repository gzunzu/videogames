package com.gzunzu.videogames.domain.mapper;

import com.gzunzu.common.domain.mapper.ModelMapper;
import com.gzunzu.videogames.domain.dto.PlatformDTO;
import com.gzunzu.videogames.domain.model.Platform;

public interface PlatformMapper extends ModelMapper<Platform, PlatformDTO> {

    @Override
    PlatformDTO toDto(final Platform platform);

    @Override
    Platform fromDto(final PlatformDTO platformDTO);
}
