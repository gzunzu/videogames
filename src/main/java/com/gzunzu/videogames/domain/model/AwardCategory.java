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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@SequenceGenerator(name = "AWARD_CATEGORY_ID_GENERATOR",
        sequenceName = "SEQ_AWARD_CATEGORY_ID",
        allocationSize = 1)
@Table(name = "AWARD_CATEGORY")
public class AwardCategory implements Serializable {
    private static final long serialVersionUID = -2157395773693101486L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "AWARD_CATEGORY_ID_GENERATOR")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "FK_INSTITUTION", referencedColumnName = "ID")
    private AwardInstitution institution;
}
