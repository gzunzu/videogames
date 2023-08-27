package com.gzunzu.videogames.domain.service;

import com.gzunzu.videogames.domain.dto.PlatformDTO;
import com.gzunzu.videogames.domain.mapper.PlatformMapper;
import com.gzunzu.videogames.domain.model.Platform;
import com.gzunzu.videogames.ports.PlatformRepository;
import com.gzunzu.videogames.ports.PlatformService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlatformServiceImpl implements PlatformService {

    final PlatformRepository platformRepository;
    final PlatformMapper platformMapper;

    @Override
    public List<PlatformDTO> getAll() {
        final List<Platform> platforms = this.platformRepository.findAll();

        return this.platformMapper.toDto().apply(platforms);
    }

    @Override
    public PlatformDTO getById(final long id) {
        final Platform platform = this.platformRepository.findById(id)
                .orElse(null);

        return this.platformMapper.toDto(platform);
    }

    @Override
    public PlatformDTO getByName(final String name) {
        Platform platform = this.platformRepository.findByNameEqualsIgnoreCase(name);

        return this.platformMapper.toDto(platform);
    }

    @Override
    public PlatformDTO insert(final PlatformDTO platformDTO) {
        final Platform platform = this.platformMapper.fromDto(platformDTO);
        final Platform result = this.platformRepository.save(platform);

        return this.platformMapper.toDto(result);
    }

    @Override
    public PlatformDTO update(final PlatformDTO platformDTO) {
        final Platform platform = this.platformMapper.fromDto(platformDTO);
        final Platform result = this.platformRepository.save(platform);

        return this.platformMapper.toDto(result);
    }

    @Override
    public boolean delete(final Long id) {
        if (this.platformRepository.existsById(id)) {
            this.platformRepository.deleteById(id);
            return !this.platformRepository.existsById(id);
        } else {
            log.info("No platform with ID {} found to delete.", id);
            return false;
        }
    }
}
