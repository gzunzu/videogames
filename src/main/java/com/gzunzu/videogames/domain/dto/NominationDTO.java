package com.gzunzu.videogames.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class NominationDTO implements Serializable {
    private static final long serialVersionUID = -5912069179572717744L;

    private long id;
    private AwardCategoryDTO category;
    private String videoGame;
    private Boolean winner;
    private LocalDate date;
}
