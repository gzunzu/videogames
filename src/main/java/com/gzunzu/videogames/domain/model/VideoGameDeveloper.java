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
@Table(name = "VIDEOGAME_DEVELOPER")
public class VideoGameDeveloper implements Serializable {
    private static final long serialVersionUID = 7040727021165191563L;

    @Id
    @SequenceGenerator(name = "videogame_developer_id_sequence",
            sequenceName = "videogame_developer_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "videogame_developer_id_sequence")
    @JsonIgnore
    private long id;

    @ManyToOne
    @JoinColumn(name = "FK_VIDEOGAME", referencedColumnName = "ID")
    @JsonBackReference
    private VideoGame videoGame;

    @ManyToOne
    @JoinColumn(name = "FK_DEVELOPER", referencedColumnName = "ID")
    @JsonManagedReference
    private Developer developer;
}
