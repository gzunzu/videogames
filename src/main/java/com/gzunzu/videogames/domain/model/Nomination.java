package com.gzunzu.videogames.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
@Table(name = "NOMINATION")
public class Nomination implements Serializable {
    private static final long serialVersionUID = -4909214543775405529L;

    @Id
    @SequenceGenerator(name = "nomination_id_sequence",
            sequenceName = "nomination_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "nomination_id_sequence")
    @JsonIgnore
    private long id;

    @ManyToOne
    @JoinColumn(name = "FK_AWARD_CATEGORY", referencedColumnName = "ID")
    @JsonManagedReference
    private AwardCategory category;

    @ManyToOne
    @JoinColumn(name = "FK_VIDEOGAME", referencedColumnName = "ID")
    @JsonBackReference
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
