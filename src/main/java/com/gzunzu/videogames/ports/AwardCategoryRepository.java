package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.model.AwardCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AwardCategoryRepository extends JpaRepository<AwardCategory, Long> {

    AwardCategory findByNameEqualsIgnoreCase(final String name);
}
