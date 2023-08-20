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

@NoArgsConstructor
@Data
@Entity
@Table(name = "VIDEOGAME_PLATFORM")
public class VideoGamePlatform implements Serializable {
    private static final long serialVersionUID = -3269595842608257225L;

    @Id
    @SequenceGenerator(name = "videogame_platform_id_sequence",
            sequenceName = "videogame_platform_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "videogame_platform_id_sequence")
    @JsonIgnore
    private long id;

    @ManyToOne
    @JoinColumn(name = "FK_VIDEOGAME", referencedColumnName = "ID")
    @JsonBackReference
    private VideoGame videoGame;

    @ManyToOne
    @JoinColumn(name = "FK_PLATFORM", referencedColumnName = "ID")
    @JsonManagedReference
    private Platform platform;
}
