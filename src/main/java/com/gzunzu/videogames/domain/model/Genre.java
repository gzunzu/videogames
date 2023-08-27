package com.gzunzu.videogames.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@SequenceGenerator(name = "GENRE_ID_GENERATOR",
        sequenceName = "SEQ_GENRE_ID",
        allocationSize = 1)
@Table(name = "GENRE")
public class Genre implements Serializable {
    private static final long serialVersionUID = -439801473649104836L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "GENRE_ID_GENERATOR")
    private Long id;

    private String name;
}
