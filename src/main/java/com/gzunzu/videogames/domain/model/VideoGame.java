package com.gzunzu.videogames.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@SequenceGenerator(name = "VIDEOGAME_ID_GENERATOR",
        sequenceName = "SEQ_VIDEOGAME_ID",
        allocationSize = 1)
@Table(name = "VIDEOGAME")
public class VideoGame implements Serializable {
    private static final long serialVersionUID = -6077773123799267364L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "VIDEOGAME_ID_GENERATOR")
    private Long id;

    private String title;

    private LocalDate releaseDate;

    private float estimatedHours;

    private boolean multiplayer;

    @JoinTable(
            name = "VIDEOGAME_GENRE",
            joinColumns = @JoinColumn(name = "FK_VIDEOGAME", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "FK_GENRE", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Genre> genres;

    @OneToMany(targetEntity = Nomination.class, mappedBy = "videoGameId", cascade = CascadeType.PERSIST)
    private List<Nomination> nominations;

    @JoinTable(
            name = "VIDEOGAME_DEVELOPER",
            joinColumns = @JoinColumn(name = "FK_VIDEOGAME", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "FK_DEVELOPER", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Developer> developers;

    @JoinTable(
            name = "VIDEOGAME_PLATFORM",
            joinColumns = @JoinColumn(name = "FK_VIDEOGAME", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "FK_PLATFORM", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Platform> platforms;
}
