package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    Developer findByNameEqualsIgnoreCase(final String name);
}
