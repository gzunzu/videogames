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
@SequenceGenerator(name = "DEVELOPER_ID_GENERATOR",
        sequenceName = "SEQ_DEVELOPER_ID",
        allocationSize = 1)
@Table(name = "DEVELOPER")
public class Developer implements Serializable {
    private static final long serialVersionUID = 5010390274569196034L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "DEVELOPER_ID_GENERATOR")
    private Long id;

    private String name;
}
