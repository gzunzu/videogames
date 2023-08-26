package com.gzunzu.videogames.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@AllArgsConstructor
@Data
@Builder
@Entity
@SequenceGenerator(name = "NOMINATION_ID_GENERATOR",
        sequenceName = "SEQ_NOMINATION_ID",
        allocationSize = 1)
@Table(name = "NOMINATION")
public class Nomination implements Serializable {
    private static final long serialVersionUID = -4909214543775405529L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "NOMINATION_ID_GENERATOR")
    private long id;

    @ManyToOne
    @JoinColumn(name = "FK_AWARD_CATEGORY", referencedColumnName = "ID")
    private AwardCategory category;

    @ManyToOne
    @JoinColumn(name = "FK_VIDEOGAME", referencedColumnName = "ID")
    private VideoGame videoGame;

    private Boolean win;

    private LocalDate date;
}
