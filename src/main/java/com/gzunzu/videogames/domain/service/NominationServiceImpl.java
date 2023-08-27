package com.gzunzu.videogames.domain.service;

import com.gzunzu.videogames.domain.dto.NominationDTO;
import com.gzunzu.videogames.domain.mapper.NominationMapper;
import com.gzunzu.videogames.domain.model.Nomination;
import com.gzunzu.videogames.ports.NominationRepository;
import com.gzunzu.videogames.ports.NominationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NominationServiceImpl implements NominationService {

    final NominationRepository nominationRepository;
    final NominationMapper nominationMapper;

    @Override
    public List<NominationDTO> getAll() {
        final List<Nomination> nominations = this.nominationRepository.findAll();

        return this.nominationMapper.toDto().apply(nominations);
    }

    @Override
    public NominationDTO getById(final long id) {
        final Nomination nomination = this.nominationRepository.findById(id)
                .orElse(null);

        return this.nominationMapper.toDto(nomination);
    }

    @Override
    public List<NominationDTO> getByInstitutionName(final String institution) {
        final List<Nomination> nominations = this.nominationRepository.findAllByCategoryInstitutionNameContainsIgnoreCase(institution);

        return this.nominationMapper.toDto().apply(nominations);
    }

    @Override
    public List<NominationDTO> getByInstitutionNameAndCategoryName(final String institution, final String category) {
        final List<Nomination> nominations = this.nominationRepository
                .findAllByCategoryInstitutionNameContainsIgnoreCaseAndCategoryNameLikeIgnoreCase(institution, category);

        return this.nominationMapper.toDto().apply(nominations);
    }

    @Override
    public List<NominationDTO> getByVideoGameTitle(final String title) {
        final List<Nomination> nominations = this.nominationRepository.findAllByVideoGameTitleContainsIgnoreCase(title);

        return this.nominationMapper.toDto().apply(nominations);
    }

    @Override
    public NominationDTO insert(final NominationDTO nominationDTO) {
        final Nomination nomination = this.nominationMapper.fromDto(nominationDTO);
        final Nomination result = this.nominationRepository.save(nomination);

        return this.nominationMapper.toDto(result);
    }

    @Override
    public NominationDTO update(final NominationDTO nominationDTO) {
        final Nomination nomination = this.nominationMapper.fromDto(nominationDTO);
        final Nomination result = this.nominationRepository.save(nomination);
        return this.nominationMapper.toDto(result);
    }

    @Override
    public boolean delete(final Long id) {
        if (this.nominationRepository.existsById(id)) {
            this.nominationRepository.deleteById(id);
            return !this.nominationRepository.existsById(id);
        } else {
            log.info("No nomination with ID {} found to delete.", id);
            return false;
        }
    }
}
