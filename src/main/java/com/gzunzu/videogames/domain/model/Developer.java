package com.gzunzu.videogames.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class Developer implements Serializable {
    private static final long serialVersionUID = 5010390274569196034L;

    private long id;

    private String name;

    public Developer(String name) {
        this.name = name;
    }
}
