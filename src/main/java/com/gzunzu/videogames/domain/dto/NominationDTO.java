package com.gzunzu.videogames.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private long id;
    private AwardCategoryDTO category;
    @JsonIgnore
    private Long videGameId;
    private Boolean win;
    private LocalDate date;
}
