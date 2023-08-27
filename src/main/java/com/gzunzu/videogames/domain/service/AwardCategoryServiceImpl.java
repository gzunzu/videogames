package com.gzunzu.videogames.domain.service;

import com.gzunzu.videogames.domain.dto.AwardCategoryDTO;
import com.gzunzu.videogames.domain.mapper.AwardCategoryMapper;
import com.gzunzu.videogames.domain.model.AwardCategory;
import com.gzunzu.videogames.ports.AwardCategoryRepository;
import com.gzunzu.videogames.ports.AwardCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AwardCategoryServiceImpl implements AwardCategoryService {

    final AwardCategoryRepository awardCategoryRepository;
    final AwardCategoryMapper awardCategoryMapper;

    @Override
    public List<AwardCategoryDTO> getAll() {
        final List<AwardCategory> awardCategories = this.awardCategoryRepository.findAll();

        return this.awardCategoryMapper.toDto().apply(awardCategories);
    }

    @Override
    public AwardCategoryDTO getById(final long id) {
        final AwardCategory awardCategory = this.awardCategoryRepository.findById(id)
                .orElse(null);

        return this.awardCategoryMapper.toDto(awardCategory);
    }

    @Override
    public List<AwardCategoryDTO> getByInstitutionName(final String institution) {
        final List<AwardCategory> awardCategories = this.awardCategoryRepository.findByInstitutionNameContainsIgnoreCase(institution);

        return this.awardCategoryMapper.toDto().apply(awardCategories);
    }

    @Override
    public List<AwardCategoryDTO> getByInstitutionNameAndCategoryName(final String institution, final String name) {
        final List<AwardCategory> awardCategories = this.awardCategoryRepository.findByInstitutionNameContainsIgnoreCaseAndNameContainsIgnoreCase(institution, name);

        return this.awardCategoryMapper.toDto().apply(awardCategories);
    }

    @Override
    public AwardCategoryDTO insert(final AwardCategoryDTO awardCategoryDTO) {
        final AwardCategory awardCategory = this.awardCategoryMapper.fromDto(awardCategoryDTO);
        final AwardCategory result = this.awardCategoryRepository.save(awardCategory);

        return this.awardCategoryMapper.toDto(result);
    }

    @Override
    public AwardCategoryDTO update(final AwardCategoryDTO awardCategoryDTO) {
        final AwardCategory awardCategory = this.awardCategoryMapper.fromDto(awardCategoryDTO);
        final AwardCategory result = this.awardCategoryRepository.save(awardCategory);

        return this.awardCategoryMapper.toDto(result);
    }

    @Override
    public boolean delete(final Long id) {
        if (this.awardCategoryRepository.existsById(id)) {
            this.awardCategoryRepository.deleteById(id);
            return !this.awardCategoryRepository.existsById(id);
        } else {
            log.info("No award category with ID {} found to delete.", id);
            return false;
        }
    }
}
