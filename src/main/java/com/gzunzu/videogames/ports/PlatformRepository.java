package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<Platform, Long> {

    Platform findByNameEqualsIgnoreCase(final String name);
}
