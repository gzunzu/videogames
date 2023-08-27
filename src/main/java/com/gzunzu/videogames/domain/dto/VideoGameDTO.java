package com.gzunzu.videogames.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class VideoGameDTO implements Serializable {
    private static final long serialVersionUID = -5089629882251828777L;

    private Long id;
    private String title;
    private LocalDate releaseDate;
    private float estimatedHours;
    private boolean multiplayer;
    private List<String> genres;
    private List<NominationDTO> nominations;
    private List<String> developers;
    private List<String> platforms;
}
