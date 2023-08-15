package com.gzunzu.videogames.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class AwardCategory implements Serializable {
    private static final long serialVersionUID = -2157395773693101486L;

    private long id;

    private String name;

    private AwardInstitution institution;

    public AwardCategory(String name, AwardInstitution institution) {
        this.name = name;
        this.institution = institution;
    }
}
