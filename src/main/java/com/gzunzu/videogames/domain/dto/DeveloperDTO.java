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
public class DeveloperDTO implements Serializable {
    private static final long serialVersionUID = 7180268093416283160L;

    @JsonIgnore
    private long id;
    private String name;
}
