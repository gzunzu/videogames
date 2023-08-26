package com.gzunzu.videogames.domain.mapper.impl;

import com.gzunzu.videogames.domain.dto.AwardInstitutionDTO;
import com.gzunzu.videogames.domain.mapper.AwardInstitutionMapper;
import com.gzunzu.videogames.domain.model.AwardInstitution;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AwardInstitutionMapperImpl implements AwardInstitutionMapper {

    @Override
    public AwardInstitutionDTO toDto(AwardInstitution awardInstitution) {
        if (awardInstitution == null) {
            return null;
        }

        return AwardInstitutionDTO.builder()
                .id(awardInstitution.getId())
                .name(awardInstitution.getName())
                .build();
    }

    @Override
    public AwardInstitution fromDto(AwardInstitutionDTO awardInstitutionDTO) {
        if (awardInstitutionDTO == null) {
            return null;
        }

        return AwardInstitution.builder()
                .id(awardInstitutionDTO.getId())
                .name(awardInstitutionDTO.getName())
                .build();
    }
}
