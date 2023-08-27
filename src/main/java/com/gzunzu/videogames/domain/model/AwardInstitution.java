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
@SequenceGenerator(name = "AWARD_INSTITUTION_ID_GENERATOR",
        sequenceName = "SEQ_AWARD_INSTITUTION_ID",
        allocationSize = 1)
@Table(name = "AWARD_INSTITUTION")
public class AwardInstitution implements Serializable {

    private static final long serialVersionUID = -2112571499772814674L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "AWARD_INSTITUTION_ID_GENERATOR")
    private Long id;

    private String name;
}
