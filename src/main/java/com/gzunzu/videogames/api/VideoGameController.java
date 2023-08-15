package com.gzunzu.videogames.api;

import com.gzunzu.videogames.domain.model.Genre;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "VideoGame controller",
        path = "api/1.0/videogame")
public class VideoGameController {

    @GetMapping
    public List<Genre> hello() {
        return List.of(new Genre("Arcade"),
                new Genre("Sports"));
    }
}
