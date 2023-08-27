package com.gzunzu.videogames.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AwardInstitutionDTO implements Serializable {
    private static final long serialVersionUID = -6088209087129108231L;

    private Long id;
    private String name;
}
