package com.gzunzu.videogames.domain.mapper.impl;

import com.gzunzu.videogames.domain.dto.PlatformDTO;
import com.gzunzu.videogames.domain.mapper.PlatformMapper;
import com.gzunzu.videogames.domain.model.Platform;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlatformMapperImpl implements PlatformMapper {

    @Override
    public PlatformDTO toDto(final Platform platform) {
        if (platform == null) {
            return null;
        }

        return PlatformDTO.builder()
                .id(platform.getId())
                .name(platform.getName())
                .build();
    }

    @Override
    public Platform fromDto(final PlatformDTO platformDTO) {
        if (platformDTO == null) {
            return null;
        }

        return Platform.builder()
                .id(platformDTO.getId())
                .name(platformDTO.getName())
                .build();
    }
}
