package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.dto.AwardCategoryDTO;

import java.util.List;

public interface AwardCategoryService {

    List<AwardCategoryDTO> getAll();

    AwardCategoryDTO getById(final long id);

    List<AwardCategoryDTO> getByInstitutionName(final String institution);

    List<AwardCategoryDTO> getByInstitutionNameAndCategoryName(final String institution, final String name);

    AwardCategoryDTO insert(final AwardCategoryDTO awardCategoryDTO);

    AwardCategoryDTO update(final AwardCategoryDTO awardCategoryDTO);

    boolean delete(final Long id);
}
