package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.model.AwardCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AwardCategoryRepository extends JpaRepository<AwardCategory, Long> {

    List<AwardCategory> findByInstitutionNameContainsIgnoreCase(final String institution);

    List<AwardCategory> findByInstitutionNameContainsIgnoreCaseAndNameContainsIgnoreCase(final String institution, final String name);
}
