package com.gzunzu.videogames.domain.mapper.impl;

import com.gzunzu.videogames.domain.dto.AwardCategoryDTO;
import com.gzunzu.videogames.domain.dto.NominationDTO;
import com.gzunzu.videogames.domain.mapper.AwardCategoryMapper;
import com.gzunzu.videogames.domain.mapper.NominationMapper;
import com.gzunzu.videogames.domain.model.AwardCategory;
import com.gzunzu.videogames.domain.model.Nomination;
import com.gzunzu.videogames.domain.model.VideoGame;
import com.gzunzu.videogames.ports.AwardCategoryRepository;
import com.gzunzu.videogames.ports.VideoGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NominationMapperImpl implements NominationMapper {

    private final AwardCategoryRepository awardCategoryRepository;
    private final AwardCategoryMapper awardCategoryMapper;
    private final VideoGameRepository videoGameRepository;

    @Override
    public Nomination fromDto(NominationDTO nominationDTO) {
        if (nominationDTO == null) {
            return null;
        }

        final AwardCategory awardCategory = this.awardCategoryRepository.findByInstitutionNameContainsIgnoreCaseAndNameContainsIgnoreCase(
                        nominationDTO.getCategory().getInstitution(),
                        nominationDTO.getCategory().getName())
                .stream()
                .findAny()
                .orElse(null);

        final VideoGame videoGame = this.videoGameRepository.findByTitleContainsIgnoreCase(nominationDTO.getVideoGame());

        return Nomination.builder()
                .id(nominationDTO.getId())
                .category(awardCategory)
                .videoGame(videoGame)
                .winner(nominationDTO.getWinner())
                .date(nominationDTO.getDate())
                .build();
    }

    @Override
    public NominationDTO toDto(Nomination nomination) {
        if (nomination == null) {
            return null;
        }

        final AwardCategoryDTO category = this.awardCategoryMapper.toDto(nomination.getCategory());

        return NominationDTO.builder()
                .id(nomination.getId())
                .category(category)
                .videoGame(nomination.getVideoGame().getTitle())
                .winner(nomination.getWinner())
                .date(nomination.getDate())
                .build();
    }
}
