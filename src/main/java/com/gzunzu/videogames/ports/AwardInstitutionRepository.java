package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.model.AwardInstitution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AwardInstitutionRepository extends JpaRepository<AwardInstitution, Long> {

    Optional<AwardInstitution> findByNameContainsIgnoreCase(final String name);
}
