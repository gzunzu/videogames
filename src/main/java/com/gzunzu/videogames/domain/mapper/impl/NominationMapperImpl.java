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

        final AwardCategory awardCategory = this.awardCategoryRepository.findByNameEqualsIgnoreCase(nominationDTO.getCategory().getName());

        final VideoGame videoGame = this.videoGameRepository.findById(nominationDTO.getVideGameId())
                .orElse(null);

        return Nomination.builder()
                .id(nominationDTO.getId())
                .category(awardCategory)
                .videoGame(videoGame)
                .win(nominationDTO.getWin())
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
                .videGameId(nomination.getVideoGame().getId())
                .win(nomination.getWin())
                .date(nomination.getDate())
                .build();
    }
}
