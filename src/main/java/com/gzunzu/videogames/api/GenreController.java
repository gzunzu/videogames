package com.gzunzu.videogames.api;

import com.gzunzu.common.adapters.api.BaseController;
import com.gzunzu.videogames.domain.dto.GenreDTO;
import com.gzunzu.videogames.ports.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "Developers controller",
        path = "api/1.0/genres",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class GenreController extends BaseController<GenreDTO> {

    private final GenreService genreService;

    @GetMapping(name = "Get all genres")
    public ResponseEntity<List<GenreDTO>> getAll() {
        final List<GenreDTO> result = this.genreService.getAll();
        return super.getResponse(result);
    }

    @GetMapping(name = "Get a genre by ID",
            value = "/{id}")
    public ResponseEntity<GenreDTO> getById(@PathVariable(name = "id") final long id) {
        final GenreDTO result = this.genreService.getById(id);
        return super.getResponse(result);
    }

    @GetMapping(name = "Get a genre by name",
            value = "/name/{name}")
    public ResponseEntity<GenreDTO> getByName(@PathVariable(name = "name") final String name) {
        final GenreDTO result = this.genreService.getByName(name);
        return super.getResponse(result);
    }

    @PostMapping(name = "Insert a genre",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenreDTO> insert(@RequestBody final GenreDTO genreDTO) {
        final GenreDTO result = this.genreService.insert(genreDTO);
        return super.postResponse(result);
    }

    @PutMapping(name = "Update a genre",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenreDTO> update(@RequestBody final GenreDTO genreDTO) {
        final GenreDTO result = this.genreService.update(genreDTO);
        return super.putResponse(result);
    }

    @DeleteMapping(name = "Delete a genre by ID",
            value = "/{id}",
            produces = MediaType.ALL_VALUE)
    public ResponseEntity<GenreDTO> delete(@PathVariable final Long id) {
        final boolean result = this.genreService.delete(id);
        return super.deleteResponse(result);
    }
}
