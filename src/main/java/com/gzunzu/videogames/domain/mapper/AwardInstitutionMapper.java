package com.gzunzu.videogames.domain.mapper;

import com.gzunzu.common.domain.mapper.ModelMapper;
import com.gzunzu.videogames.domain.dto.AwardInstitutionDTO;
import com.gzunzu.videogames.domain.model.AwardInstitution;

public interface AwardInstitutionMapper extends ModelMapper<AwardInstitution, AwardInstitutionDTO> {

    AwardInstitutionDTO toDto(final AwardInstitution awardInstitution);

    AwardInstitution fromDto(final AwardInstitutionDTO awardInstitutionDTO);
}
