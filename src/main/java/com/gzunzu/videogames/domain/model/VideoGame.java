package com.gzunzu.videogames.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Data
public class VideoGame implements Serializable {
    private static final long serialVersionUID = -6077773123799267364L;

    private long id;

    private String title;

    private LocalDate releaseDate;

    private List<Genre> genres;

    private List<Nomination> nominations;

    private List<Developer> developers;
}
