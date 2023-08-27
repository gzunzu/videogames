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
public class PlatformDTO implements Serializable {
    private static final long serialVersionUID = -8690887009976218446L;

    @JsonIgnore
    private Long id;
    private String name;
}
