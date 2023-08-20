package com.gzunzu.videogames.domain.model;

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
@Table(name = "AWARD_CATEGORY")
public class AwardCategory implements Serializable {
    private static final long serialVersionUID = -2157395773693101486L;

    @Id
    @SequenceGenerator(name = "award-category_id_sequence",
            sequenceName = "award-category_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "award-category_id_sequence")
    @JsonIgnore
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "FK_INSTITUTION", referencedColumnName = "ID")
    @JsonManagedReference
    private AwardInstitution institution;

    public AwardCategory(String name, AwardInstitution institution) {
        this.name = name;
        this.institution = institution;
    }
}
