package com.gzunzu.videogames.domain.mapper;

import com.gzunzu.common.domain.mapper.ModelMapper;
import com.gzunzu.videogames.domain.dto.NominationDTO;
import com.gzunzu.videogames.domain.model.Nomination;

public interface NominationMapper extends ModelMapper<Nomination, NominationDTO> {

    @Override
    NominationDTO toDto(final Nomination nomination);

    @Override
    Nomination fromDto(final NominationDTO nominationDTO);
}
