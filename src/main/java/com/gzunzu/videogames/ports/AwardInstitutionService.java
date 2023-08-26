package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.dto.AwardInstitutionDTO;
import com.gzunzu.videogames.domain.model.AwardInstitution;

import java.util.List;

public interface AwardInstitutionService {

    List<AwardInstitution> getAll();

    AwardInstitution getById(final long id);

    AwardInstitution getByName(final String name);

    AwardInstitution insert(final AwardInstitutionDTO awardInstitutionDTO);

    AwardInstitution update(final AwardInstitution awardInstitution);

    boolean delete(final Long id);
}
