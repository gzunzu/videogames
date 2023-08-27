package com.gzunzu.videogames.domain.mapper.impl;

import com.gzunzu.videogames.domain.dto.AwardCategoryDTO;
import com.gzunzu.videogames.domain.mapper.AwardCategoryMapper;
import com.gzunzu.videogames.domain.model.AwardCategory;
import com.gzunzu.videogames.domain.model.AwardInstitution;
import com.gzunzu.videogames.ports.AwardInstitutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AwardCategoryMapperImpl implements AwardCategoryMapper {

    private final AwardInstitutionRepository awardInstitutionRepository;

    @Override
    public AwardCategoryDTO toDto(AwardCategory awardCategory) {
        if (awardCategory == null) {
            return null;
        }

        return AwardCategoryDTO.builder()
                .id(awardCategory.getId())
                .name(awardCategory.getName())
                .institution(awardCategory.getInstitution().getName())
                .build();
    }

    @Override
    public AwardCategory fromDto(AwardCategoryDTO awardCategoryDTO) {
        if (awardCategoryDTO == null) {
            return null;
        }

        final AwardInstitution institution = this.awardInstitutionRepository.findByNameContainsIgnoreCase(awardCategoryDTO.getInstitution());

        return AwardCategory.builder()
                .id(awardCategoryDTO.getId())
                .name(awardCategoryDTO.getName())
                .institution(institution)
                .build();
    }
}
