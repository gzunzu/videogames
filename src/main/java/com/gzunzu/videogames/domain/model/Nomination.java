package com.gzunzu.videogames.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Data
public class Nomination implements Serializable {
    private static final long serialVersionUID = -4909214543775405529L;

    private long id;

    private AwardCategory category;

    private VideoGame videoGame;

    private Boolean win;

    private LocalDate date;

    public Nomination(AwardCategory category, VideoGame videoGame, Boolean win, LocalDate date) {
        this.category = category;
        this.videoGame = videoGame;
        this.win = win;
        this.date = date;
    }
}
