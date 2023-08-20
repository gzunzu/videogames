package com.gzunzu.videogames.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "VIDEOGAME")
public class VideoGame implements Serializable {
    private static final long serialVersionUID = -6077773123799267364L;

    @Id
    @SequenceGenerator(name = "videogame_id_sequence",
            sequenceName = "videogame_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "videogame_id_sequence")
    @JsonIgnore
    private long id;

    private String title;

    private LocalDate releaseDate;

    private float estimatedHours;

    private boolean multiplayer;

    @OneToMany(targetEntity = VideoGameGenre.class, mappedBy = "videoGame")
    @JsonManagedReference
    private List<Genre> genres;

    @OneToMany(targetEntity = Nomination.class, mappedBy = "videoGame")
    @JsonManagedReference
    private List<Nomination> nominations;

    @OneToMany(targetEntity = VideoGameDeveloper.class, mappedBy = "videoGame")
    @JsonManagedReference
    private List<Developer> developers;

    @OneToMany(targetEntity = VideoGamePlatform.class, mappedBy = "videoGame")
    @JsonManagedReference
    private List<Platform> platforms;

    public VideoGame(String title, LocalDate releaseDate, List<Genre> genres, List<Nomination> nominations, List<Developer> developers) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.genres = genres;
        this.nominations = nominations;
        this.developers = developers;
    }
}
