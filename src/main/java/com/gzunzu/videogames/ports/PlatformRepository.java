package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlatformRepository extends JpaRepository<Platform, Long> {

    Optional<Platform> findByNameEqualsIgnoreCase(final String name);
}
