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
@Table(name = "DEVELOPER")
public class Developer implements Serializable {
    private static final long serialVersionUID = 5010390274569196034L;

    @Id
    @SequenceGenerator(name = "developer_id_sequence",
            sequenceName = "developer_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "developer_id_sequence")
    @JsonIgnore
    private long id;

    private String name;

    public Developer(String name) {
        this.name = name;
    }
}
