package com.gzunzu.videogames.domain.mapper.impl;

import com.gzunzu.videogames.domain.dto.AwardCategoryDTO;
import com.gzunzu.videogames.domain.dto.NominationDTO;
import com.gzunzu.videogames.domain.mapper.AwardCategoryMapper;
import com.gzunzu.videogames.domain.mapper.NominationMapper;
import com.gzunzu.videogames.domain.model.AwardCategory;
import com.gzunzu.videogames.domain.model.Nomination;
import com.gzunzu.videogames.ports.AwardCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NominationMapperImpl implements NominationMapper {

    private final AwardCategoryRepository awardCategoryRepository;
    private final AwardCategoryMapper awardCategoryMapper;

    @Override
    public Nomination fromDto(final NominationDTO nominationDTO) {
        if (nominationDTO == null || nominationDTO.getVideoGameId() == null) {
            return null;
        }

        final AwardCategory awardCategory = this.awardCategoryRepository.findByInstitutionNameContainsIgnoreCaseAndNameContainsIgnoreCase(
                        nominationDTO.getCategory().getInstitution(),
                        nominationDTO.getCategory().getName())
                .stream()
                .findAny()
                .orElse(null);

        return Nomination.builder()
                .id(nominationDTO.getId())
                .category(awardCategory)
                .videoGameId(nominationDTO.getVideoGameId())
                .winner(nominationDTO.getWinner())
                .date(nominationDTO.getDate())
                .build();
    }

    @Override
    public NominationDTO toDto(final Nomination nomination) {
        if (nomination == null) {
            return null;
        }

        final AwardCategoryDTO category = this.awardCategoryMapper.toDto(nomination.getCategory());

        return NominationDTO.builder()
                .id(nomination.getId())
                .category(category)
                .videoGameId(nomination.getVideoGameId())
                .winner(nomination.getWinner())
                .date(nomination.getDate())
                .build();
    }
}
