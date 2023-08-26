package com.gzunzu.videogames.api;

import com.gzunzu.common.adapters.api.BaseController;
import com.gzunzu.videogames.domain.dto.VideoGameDTO;
import com.gzunzu.videogames.ports.VideoGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "Video games controller",
        path = "api/1.0/videogames",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class VideoGameController extends BaseController<VideoGameDTO> {

    private final VideoGameService videoGameService;

    @GetMapping(name = "Get all video games")
    public ResponseEntity<List<VideoGameDTO>> getAll() {
        final List<VideoGameDTO> result = this.videoGameService.getAll();
        return super.getResponse(result);
    }

    @GetMapping(name = "Get a video game by title",
            value = "/{title}")
    public ResponseEntity<VideoGameDTO> getByTitle(@PathVariable(name = "title") final String title) {
        final VideoGameDTO result = this.videoGameService.getByTitle(title);
        return super.getResponse(result);
    }

    @GetMapping(name = "Get all video games released during the provided year",
            value = "/year/{year}")
    public ResponseEntity<List<VideoGameDTO>> getByReleaseYear(@PathVariable(name = "year") final int year) {
        final List<VideoGameDTO> result = this.videoGameService.getByReleaseYear(year);
        return super.getResponse(result);
    }

    @GetMapping(name = "Get all video games by genre",
            value = "/genre/{name}")
    public ResponseEntity<List<VideoGameDTO>> getByGenre(@PathVariable(name = "name") final String name) {
        final List<VideoGameDTO> result = this.videoGameService.getByGenre(name);
        return super.getResponse(result);
    }

    @GetMapping(name = "Get all video games by platform",
            value = "/platform/{name}")
    public ResponseEntity<List<VideoGameDTO>> getByPlatform(@PathVariable(name = "name") final String name) {
        final List<VideoGameDTO> result = this.videoGameService.getByPlatform(name);
        return super.getResponse(result);
    }

    @GetMapping(name = "Get all video games by developer",
            value = "/developer/{name}")
    public ResponseEntity<List<VideoGameDTO>> getByDeveloper(@PathVariable(name = "name") final String name) {
        final List<VideoGameDTO> result = this.videoGameService.getByDeveloper(name);
        return super.getResponse(result);
    }
}