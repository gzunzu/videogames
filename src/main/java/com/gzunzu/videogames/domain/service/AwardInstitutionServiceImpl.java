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
    public List<AwardInstitution> getAll() {
        return this.awardInstitutionRepository.findAll();
    }

    @Override
    public AwardInstitution getById(final long id) {
        return this.awardInstitutionRepository.findById(id)
                .orElse(null);
    }

    @Override
    public AwardInstitution getByName(final String name) {
        return this.awardInstitutionRepository.findByNameEqualsIgnoreCase(name);
    }

    @Override
    public AwardInstitution insert(final AwardInstitutionDTO awardInstitutionDTO) {
        final AwardInstitution awardInstitution = this.awardInstitutionMapper.fromDto(awardInstitutionDTO);
        return this.awardInstitutionRepository.save(awardInstitution);
    }

    @Override
    public AwardInstitution update(final AwardInstitution awardInstitution) {
        return this.awardInstitutionRepository.save(awardInstitution);
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
