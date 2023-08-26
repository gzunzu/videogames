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
public class GenreDTO implements Serializable {
    private static final long serialVersionUID = -5233499640832300344L;

    @JsonIgnore
    private long id;
    private String name;
}
