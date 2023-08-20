package com.gzunzu.videogames.api;

import com.gzunzu.videogames.domain.model.VideoGame;
import com.gzunzu.videogames.ports.VideoGameService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "VideoGame controller",
        path = "api/1.0/videogames")
@RequiredArgsConstructor
public class VideoGameController {

    private final VideoGameService videoGameService;

    @GetMapping
    public ResponseEntity<List<VideoGame>> getAll() {
        final List<VideoGame> result = this.videoGameService.getAll();
        return CollectionUtils.isEmpty(result) ? ResponseEntity.noContent().build() : ResponseEntity.ok(result);
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<VideoGame>> getByGenre(@PathVariable(name = "genre") final String genre) {
        final List<VideoGame> result = this.videoGameService.getByGenre(genre);
        return CollectionUtils.isEmpty(result) ? ResponseEntity.noContent().build() : ResponseEntity.ok(result);
    }
}