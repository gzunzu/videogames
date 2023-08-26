package com.gzunzu.videogames.domain.mapper;

import com.gzunzu.common.domain.mapper.ModelMapper;
import com.gzunzu.videogames.domain.dto.AwardCategoryDTO;
import com.gzunzu.videogames.domain.model.AwardCategory;

public interface AwardCategoryMapper extends ModelMapper<AwardCategory, AwardCategoryDTO> {

    @Override
    AwardCategoryDTO toDto(final AwardCategory awardCategory);

    @Override
    AwardCategory fromDto(final AwardCategoryDTO awardCategoryDTO);
}
