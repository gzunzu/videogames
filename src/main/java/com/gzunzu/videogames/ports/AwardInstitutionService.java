package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.dto.AwardInstitutionDTO;

import java.util.List;

public interface AwardInstitutionService {

    List<AwardInstitutionDTO> getAll();

    AwardInstitutionDTO getById(final long id);

    AwardInstitutionDTO getByName(final String name);

    AwardInstitutionDTO insert(final AwardInstitutionDTO awardInstitutionDTO);

    AwardInstitutionDTO update(final AwardInstitutionDTO awardInstitutionDTO);

    boolean delete(final Long id);
}
