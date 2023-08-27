package com.gzunzu.videogames.api;

import com.gzunzu.common.adapters.api.BaseController;
import com.gzunzu.videogames.domain.dto.AwardInstitutionDTO;
import com.gzunzu.videogames.ports.AwardInstitutionService;
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
@RequestMapping(name = "Award institutions controller",
        path = "api/1.0/institutions",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AwardInstitutionController extends BaseController<AwardInstitutionDTO> {

    private final AwardInstitutionService awardInstitutionService;

    @GetMapping(name = "Get all award institutions")
    public ResponseEntity<List<AwardInstitutionDTO>> getAll() {
        final List<AwardInstitutionDTO> result = this.awardInstitutionService.getAll();
        return super.getResponse(result);
    }

    @GetMapping(name = "Get an award institution by ID",
            value = "/{id}")
    public ResponseEntity<AwardInstitutionDTO> getById(@PathVariable(name = "id") final long id) {
        final AwardInstitutionDTO result = this.awardInstitutionService.getById(id);
        return super.getResponse(result);
    }

    @GetMapping(name = "Get an award institution by name",
            value = "/name/{name}")
    public ResponseEntity<AwardInstitutionDTO> getByName(@PathVariable(name = "name") final String name) {
        final AwardInstitutionDTO result = this.awardInstitutionService.getByName(name);
        return super.getResponse(result);
    }

    @PostMapping(name = "Insert an award institution",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AwardInstitutionDTO> insert(@RequestBody final AwardInstitutionDTO awardInstitutionDTO) {
        final AwardInstitutionDTO result = this.awardInstitutionService.insert(awardInstitutionDTO);
        return super.postResponse(result);
    }

    @PutMapping(name = "Update an award institution",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AwardInstitutionDTO> update(@RequestBody final AwardInstitutionDTO awardInstitutionDTO) {
        final AwardInstitutionDTO result = this.awardInstitutionService.update(awardInstitutionDTO);
        return super.putResponse(result);
    }

    @DeleteMapping(name = "Delete an award institution by ID",
            value = "/{id}",
            produces = MediaType.ALL_VALUE)
    public ResponseEntity<AwardInstitutionDTO> delete(@PathVariable final Long id) {
        final boolean result = this.awardInstitutionService.delete(id);
        return super.deleteResponse(result);
    }
}
