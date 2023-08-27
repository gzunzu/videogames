package com.gzunzu.videogames.api;

import com.gzunzu.common.adapters.api.BaseController;
import com.gzunzu.videogames.domain.dto.PlatformDTO;
import com.gzunzu.videogames.ports.PlatformService;
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
@RequestMapping(name = "Platforms controller",
        path = "api/1.0/platforms",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PlatformController extends BaseController<PlatformDTO> {

    private final PlatformService platformService;

    @GetMapping(name = "Get all platforms")
    public ResponseEntity<List<PlatformDTO>> getAll() {
        final List<PlatformDTO> result = this.platformService.getAll();
        return super.getResponse(result);
    }

    @GetMapping(name = "Get a platform by ID",
            value = "/{id}")
    public ResponseEntity<PlatformDTO> getById(@PathVariable(name = "id") final long id) {
        final PlatformDTO result = this.platformService.getById(id);
        return super.getResponse(result);
    }

    @GetMapping(name = "Get a platform by name",
            value = "/name/{name}")
    public ResponseEntity<PlatformDTO> getByName(@PathVariable(name = "name") final String name) {
        final PlatformDTO result = this.platformService.getByName(name);
        return super.getResponse(result);
    }

    @PostMapping(name = "Insert a platform",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlatformDTO> insert(@RequestBody final PlatformDTO platformDTO) {
        final PlatformDTO result = this.platformService.insert(platformDTO);
        return super.postResponse(result);
    }

    @PutMapping(name = "Update a platform",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlatformDTO> update(@RequestBody final PlatformDTO platformDTO) {
        final PlatformDTO result = this.platformService.update(platformDTO);
        return super.putResponse(result);
    }

    @DeleteMapping(name = "Delete a platform by ID",
            value = "/{id}",
            produces = MediaType.ALL_VALUE)
    public ResponseEntity<PlatformDTO> delete(@PathVariable final Long id) {
        final boolean result = this.platformService.delete(id);
        return super.deleteResponse(result);
    }
}
