package com.gzunzu.videogames.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AwardCategoryDTO implements Serializable {
    private static final long serialVersionUID = -6107308325321045825L;

    @JsonIgnore
    private long id;
    private String name;
    private String institution;
}
