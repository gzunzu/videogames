package com.gzunzu.videogames.api;

import com.gzunzu.videogames.domain.model.VideoGame;
import com.gzunzu.videogames.ports.VideoGameService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "VideoGame controller",
        path = "api/1.0/videogames",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class VideoGameController {

    private final VideoGameService videoGameService;

    @GetMapping(name = "Get all video games")
    public ResponseEntity<List<VideoGame>> getAll() {
        final List<VideoGame> result = this.videoGameService.getAll();
        return CollectionUtils.isEmpty(result) ? ResponseEntity.noContent().build() : ResponseEntity.ok(result);
    }

    @GetMapping(name = "Get a video game by title",
            value = "/{title}")
    public ResponseEntity<VideoGame> getByTitle(@PathVariable(name = "title") final String title) {
        final VideoGame result = this.videoGameService.getByTitle(title);
        return result == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(result);
    }

    @GetMapping(name = "Get all video games released during the provided year",
            value = "/year/{year}")
    public ResponseEntity<List<VideoGame>> getByReleaseYear(@PathVariable(name = "year") final int year) {
        final List<VideoGame> result = this.videoGameService.getByReleaseYear(year);
        return CollectionUtils.isEmpty(result) ? ResponseEntity.notFound().build() : ResponseEntity.ok(result);
    }
}