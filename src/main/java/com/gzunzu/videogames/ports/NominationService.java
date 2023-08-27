package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.dto.NominationDTO;

import java.util.List;

public interface NominationService {

    List<NominationDTO> getAll();

    NominationDTO getById(final long id);

    List<NominationDTO> getByInstitutionName(final String institution);

    List<NominationDTO> getByInstitutionNameAndCategoryName(final String institution, final String category);

    List<NominationDTO> getByVideoGameTitle(final String title);

    NominationDTO insert(final NominationDTO nominationDTO);

    NominationDTO update(final NominationDTO nominationDTO);

    boolean delete(final Long id);
}
