package com.gzunzu.videogames.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class AwardInstitution implements Serializable {

    private static final long serialVersionUID = -2112571499772814674L;

    private long id;

    private String name;

    public AwardInstitution(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
