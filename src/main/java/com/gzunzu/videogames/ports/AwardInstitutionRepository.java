package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.model.AwardInstitution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AwardInstitutionRepository extends JpaRepository<AwardInstitution, Long> {

    AwardInstitution findByNameEqualsIgnoreCase(final String name);

    AwardInstitution save(final AwardInstitution awardInstitution);
}
