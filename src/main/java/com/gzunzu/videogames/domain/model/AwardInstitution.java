package com.gzunzu.videogames.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "AWARD_INSTITUTION")
public class AwardInstitution implements Serializable {

    private static final long serialVersionUID = -2112571499772814674L;

    @Id
    @SequenceGenerator(name = "award-institution_id_sequence",
            sequenceName = "award-institution_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "award-institution_id_sequence")
    @JsonIgnore
    private long id;

    private String name;

    @OneToMany(targetEntity = AwardCategory.class, mappedBy = "institution")
    @JsonIgnore
    private List<AwardCategory> awardCategories;

    public AwardInstitution(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
