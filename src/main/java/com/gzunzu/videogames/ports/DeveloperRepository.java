package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    Optional<Developer> findByNameEqualsIgnoreCase(final String name);
}
