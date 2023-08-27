package com.gzunzu.videogames.domain.mapper.impl;

import com.gzunzu.videogames.domain.dto.DeveloperDTO;
import com.gzunzu.videogames.domain.mapper.DeveloperMapper;
import com.gzunzu.videogames.domain.model.Developer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeveloperMapperImpl implements DeveloperMapper {

    @Override
    public DeveloperDTO toDto(Developer developer) {
        if (developer == null) {
            return null;
        }

        return DeveloperDTO.builder()
                .id(developer.getId())
                .name(developer.getName())
                .build();
    }

    @Override
    public Developer fromDto(DeveloperDTO developerDTO) {
        if (developerDTO == null) {
            return null;
        }

        return Developer.builder()
                .id(developerDTO.getId())
                .name(developerDTO.getName())
                .build();
    }
}
