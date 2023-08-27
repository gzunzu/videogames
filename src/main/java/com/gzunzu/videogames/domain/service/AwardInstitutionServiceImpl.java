package com.gzunzu.videogames.domain.service;

import com.gzunzu.videogames.domain.dto.AwardInstitutionDTO;
import com.gzunzu.videogames.domain.mapper.AwardInstitutionMapper;
import com.gzunzu.videogames.domain.model.AwardInstitution;
import com.gzunzu.videogames.ports.AwardInstitutionRepository;
import com.gzunzu.videogames.ports.AwardInstitutionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AwardInstitutionServiceImpl implements AwardInstitutionService {

    final AwardInstitutionRepository awardInstitutionRepository;
    final AwardInstitutionMapper awardInstitutionMapper;

    @Override
    public List<AwardInstitutionDTO> getAll() {
        final List<AwardInstitution> awardInstitutions = this.awardInstitutionRepository.findAll();

        return this.awardInstitutionMapper.toDto().apply(awardInstitutions);
    }

    @Override
    public AwardInstitutionDTO getById(final long id) {
        final AwardInstitution awardInstitution = this.awardInstitutionRepository.findById(id)
                .orElse(null);

        return this.awardInstitutionMapper.toDto(awardInstitution);
    }

    @Override
    public AwardInstitutionDTO getByName(final String name) {
        final AwardInstitution awardInstitution = this.awardInstitutionRepository.findByNameContainsIgnoreCase(name);

        return this.awardInstitutionMapper.toDto(awardInstitution);
    }

    @Override
    public AwardInstitutionDTO insert(final AwardInstitutionDTO awardInstitutionDTO) {
        final AwardInstitution awardInstitution = this.awardInstitutionMapper.fromDto(awardInstitutionDTO);
        final AwardInstitution result = this.awardInstitutionRepository.save(awardInstitution);

        return this.awardInstitutionMapper.toDto(result);
    }

    @Override
    public AwardInstitutionDTO update(final AwardInstitutionDTO awardInstitutionDTO) {
        final AwardInstitution awardInstitution = this.awardInstitutionMapper.fromDto(awardInstitutionDTO);
        final AwardInstitution result = this.awardInstitutionRepository.save(awardInstitution);

        return this.awardInstitutionMapper.toDto(result);
    }

    @Override
    public boolean delete(final Long id) {
        if (this.awardInstitutionRepository.existsById(id)) {
            this.awardInstitutionRepository.deleteById(id);
            return !this.awardInstitutionRepository.existsById(id);
        } else {
            log.info("No award institution with ID {} found to delete.", id);
            return false;
        }
    }
}
