package com.gzunzu.videogames.api;

import com.gzunzu.common.adapters.api.BaseController;
import com.gzunzu.videogames.domain.dto.DeveloperDTO;
import com.gzunzu.videogames.ports.DeveloperService;
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
        path = "api/1.0/developers",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class DeveloperController extends BaseController<DeveloperDTO> {

    private final DeveloperService developerService;

    @GetMapping(name = "Get all developers")
    public ResponseEntity<List<DeveloperDTO>> getAll() {
        final List<DeveloperDTO> result = this.developerService.getAll();
        return super.getResponse(result);
    }

    @GetMapping(name = "Get a developer by ID",
            value = "/{id}")
    public ResponseEntity<DeveloperDTO> getById(@PathVariable(name = "id") final long id) {
        final DeveloperDTO result = this.developerService.getById(id);
        return super.getResponse(result);
    }

    @GetMapping(name = "Get a developer by name",
            value = "/name/{name}")
    public ResponseEntity<DeveloperDTO> getByName(@PathVariable(name = "name") final String name) {
        final DeveloperDTO result = this.developerService.getByName(name);
        return super.getResponse(result);
    }

    @PostMapping(name = "Insert a developer",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeveloperDTO> insert(@RequestBody final DeveloperDTO developerDTO) {
        final DeveloperDTO result = this.developerService.insert(developerDTO);
        return super.postResponse(result);
    }

    @PutMapping(name = "Update a developer",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeveloperDTO> update(@RequestBody final DeveloperDTO developerDTO) {
        final DeveloperDTO result = this.developerService.update(developerDTO);
        return super.putResponse(result);
    }

    @DeleteMapping(name = "Delete a developer by ID",
            value = "/{id}",
            produces = MediaType.ALL_VALUE)
    public ResponseEntity<DeveloperDTO> delete(@PathVariable final Long id) {
        final boolean result = this.developerService.delete(id);
        return super.deleteResponse(result);
    }
}
