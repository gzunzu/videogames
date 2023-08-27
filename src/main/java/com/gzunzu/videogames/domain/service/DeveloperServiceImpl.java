package com.gzunzu.videogames.domain.service;

import com.gzunzu.videogames.domain.dto.DeveloperDTO;
import com.gzunzu.videogames.domain.mapper.DeveloperMapper;
import com.gzunzu.videogames.domain.model.Developer;
import com.gzunzu.videogames.ports.DeveloperRepository;
import com.gzunzu.videogames.ports.DeveloperService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeveloperServiceImpl implements DeveloperService {

    final DeveloperRepository developerRepository;
    final DeveloperMapper developerMapper;

    @Override
    public List<DeveloperDTO> getAll() {
        final List<Developer> developers = this.developerRepository.findAll();

        return this.developerMapper.toDto().apply(developers);
    }

    @Override
    public DeveloperDTO getById(final long id) {
        final Developer developer = this.developerRepository.findById(id)
                .orElse(null);

        return this.developerMapper.toDto(developer);
    }

    @Override
    public DeveloperDTO getByName(final String name) {
        final Developer developer = this.developerRepository.findByNameEqualsIgnoreCase(name)
                .orElse(null);

        return this.developerMapper.toDto(developer);
    }

    @Override
    public DeveloperDTO insert(final DeveloperDTO developerDTO) {
        final Developer developer = this.developerMapper.fromDto(developerDTO);
        final Developer result = this.developerRepository.save(developer);

        return this.developerMapper.toDto(result);
    }

    @Override
    public DeveloperDTO update(final DeveloperDTO developerDTO) {
        final Developer developer = this.developerMapper.fromDto(developerDTO);
        final Developer result = this.developerRepository.save(developer);

        return this.developerMapper.toDto(result);
    }

    @Override
    public boolean delete(final Long id) {
        if (this.developerRepository.existsById(id)) {
            this.developerRepository.deleteById(id);
            return !this.developerRepository.existsById(id);
        } else {
            log.info("No developer with ID {} found to delete.", id);
            return false;
        }
    }
}
