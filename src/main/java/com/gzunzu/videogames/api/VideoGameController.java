package com.gzunzu.videogames.api;

import com.gzunzu.common.adapters.api.BaseController;
import com.gzunzu.videogames.domain.dto.VideoGameDTO;
import com.gzunzu.videogames.ports.VideoGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
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

    @GetMapping(name = "Get a video game by ID",
            value = "/{id}")
    public ResponseEntity<VideoGameDTO> getByTitle(@PathVariable(name = "id") final Long id) {
        final VideoGameDTO result = this.videoGameService.getById(id);
        return super.getResponse(result);
    }

    @GetMapping(name = "Get a video game by title",
            value = "/title/{title}")
    public ResponseEntity<List<VideoGameDTO>> getByTitle(@PathVariable(name = "title") final String title) {
        final List<VideoGameDTO> result = this.videoGameService.getByTitle(title);
        return super.getResponse(result);
    }

    @GetMapping(name = "Get all video games released during the provided year",
            value = "/year/{year}")
    public ResponseEntity<List<VideoGameDTO>> getByReleaseYear(@PathVariable(name = "year") final int year) {
        final List<VideoGameDTO> result = this.videoGameService.getByReleaseYear(year);
        return super.getResponse(result);
    }

    @GetMapping(name = "Get all video games by genre",
            value = "/genre/{genreName}")
    public ResponseEntity<List<VideoGameDTO>> getByGenre(@PathVariable(name = "genreName") final String genreName) {
        final List<VideoGameDTO> result = this.videoGameService.getByGenre(genreName);
        return super.getResponse(result);
    }

    @GetMapping(name = "Get all video games by platform",
            value = "/platform/{platformName}")
    public ResponseEntity<List<VideoGameDTO>> getByPlatform(@PathVariable(name = "platformName") final String platformName) {
        final List<VideoGameDTO> result = this.videoGameService.getByPlatform(platformName);
        return super.getResponse(result);
    }

    @GetMapping(name = "Get all video games by developer",
            value = "/developer/{developerName}")
    public ResponseEntity<List<VideoGameDTO>> getByDeveloper(@PathVariable(name = "developerName") final String developerName) {
        final List<VideoGameDTO> result = this.videoGameService.getByDeveloper(developerName);
        return super.getResponse(result);
    }

    @PostMapping(name = "Insert a video game")
    public ResponseEntity<VideoGameDTO> insert(@RequestBody final VideoGameDTO videoGameDTO) {
        final VideoGameDTO result = this.videoGameService.insert(videoGameDTO);
        return super.getResponse(result);
    }

    @PatchMapping(name = "Update a video game's title",
            value = "/{id}/title")
    public ResponseEntity<VideoGameDTO> updateTitle(@PathVariable(name = "id") final Long id,
                                                    @RequestParam(value = "title") final String title) {
        final VideoGameDTO result = this.videoGameService.updateTitle(id, title);
        return super.getResponse(result);
    }

    @PatchMapping(name = "Update a video game's release date",
            value = "/{id}/release-date")
    public ResponseEntity<VideoGameDTO> updateReleaseDate(@PathVariable(name = "id") final Long id,
                                                          @RequestParam(value = "release-date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate releaseDate) {
        final VideoGameDTO result = this.videoGameService.updateReleaseDate(id, releaseDate);
        return super.getResponse(result);
    }

    @PatchMapping(name = "Update a video game's estimated hours",
            value = "/{id}/estimated-hours")
    public ResponseEntity<VideoGameDTO> updateEstimatedHours(@PathVariable(name = "id") final Long id,
                                                             @RequestParam(value = "estimated-hours") final float estimatedHours) {
        final VideoGameDTO result = this.videoGameService.updateEstimatedHours(id, estimatedHours);
        return super.getResponse(result);
    }

    @PatchMapping(name = "Update a video game's multiplayer attribute",
            value = "/{id}/multiplayer")
    public ResponseEntity<VideoGameDTO> updateMultiplayer(@PathVariable(name = "id") final Long id,
                                                          @RequestParam final boolean multiplayer) {
        final VideoGameDTO result = this.videoGameService.updateMultiplayer(id, multiplayer);
        return super.getResponse(result);
    }

    @PatchMapping(name = "Update (override) a video game's genres list",
            value = "/{id}/genres")
    public ResponseEntity<VideoGameDTO> updateGenres(@PathVariable(name = "id") final Long id,
                                                     @RequestBody final String[] genreNames) {
        final VideoGameDTO result = this.videoGameService.updateGenres(id, genreNames);
        return super.getResponse(result);
    }

    @PatchMapping(name = "Update (override) a video game's platforms list",
            value = "/{id}/platforms")
    public ResponseEntity<VideoGameDTO> updatePlatforms(@PathVariable(name = "id") final Long id,
                                                        @RequestBody final String[] platformNames) {
        final VideoGameDTO result = this.videoGameService.updatePlatforms(id, platformNames);
        return super.getResponse(result);
    }

    @PatchMapping(name = "Update (override) a video game's developers list",
            value = "/{id}/developers")
    public ResponseEntity<VideoGameDTO> updateDevelopers(@PathVariable(name = "id") final Long id,
                                                         @RequestBody final String[] developerNames) {
        final VideoGameDTO result = this.videoGameService.updateDevelopers(id, developerNames);
        return super.getResponse(result);
    }

    @DeleteMapping(name = "Delete a video game by ID",
            value = "/{id}")
    public ResponseEntity<VideoGameDTO> delete(@PathVariable(name = "id") final Long id) {
        final boolean result = this.videoGameService.delete(id);
        return super.deleteResponse(result);
    }
}