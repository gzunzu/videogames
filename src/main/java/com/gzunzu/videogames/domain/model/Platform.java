package com.gzunzu.videogames.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Data
@Entity
@Table(name = "PLATFORM")
public class Platform implements Serializable {
    private static final long serialVersionUID = -439801473649104836L;

    @Id
    @SequenceGenerator(name = "platform_id_sequence",
            sequenceName = "platform_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "platform_id_sequence")
    @JsonIgnore
    private long id;

    private String name;

    public Platform(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
