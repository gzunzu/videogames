package com.gzunzu.videogames.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class Genre implements Serializable {
    private static final long serialVersionUID = -439801473649104836L;

    private long id;

    private String name;

    public Genre(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
