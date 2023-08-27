package com.gzunzu.videogames.ports;

import com.gzunzu.videogames.domain.model.Nomination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NominationRepository extends JpaRepository<Nomination, Long> {

    List<Nomination> findAllByCategoryInstitutionNameContainsIgnoreCaseAndCategoryNameLikeIgnoreCase(
            final String institution,
            final String category);

    List<Nomination> findAllByCategoryInstitutionNameContainsIgnoreCase(final String institution);

    List<Nomination> findAllByVideoGameId(final Long videoGameId);
}
