package com.gzunzu.videogames.api;

import com.gzunzu.common.adapters.api.BaseController;
import com.gzunzu.videogames.domain.dto.AwardInstitutionDTO;
import com.gzunzu.videogames.domain.model.AwardInstitution;
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
public class AwardInstitutionController extends BaseController<AwardInstitution> {

    private final AwardInstitutionService awardInstitutionService;

    @GetMapping(name = "Get all award institutions")
    public ResponseEntity<List<AwardInstitution>> getAll() {
        final List<AwardInstitution> result = this.awardInstitutionService.getAll();
        return super.getResponse(result);
    }

    @GetMapping(name = "Get an award institution by ID",
            value = "/{id}")
    public ResponseEntity<AwardInstitution> getById(@PathVariable(name = "id") final long id) {
        final AwardInstitution result = this.awardInstitutionService.getById(id);
        return super.getResponse(result);
    }

    @GetMapping(name = "Get an award institution by name",
            value = "/name/{name}")
    public ResponseEntity<AwardInstitution> getByName(@PathVariable(name = "name") final String name) {
        final AwardInstitution result = this.awardInstitutionService.getByName(name);
        return super.getResponse(result);
    }

    @PostMapping(name = "Insert an award institution")
    public ResponseEntity<AwardInstitution> insert(@RequestBody final AwardInstitutionDTO awardInstitutionDTO) {
        final AwardInstitution result = this.awardInstitutionService.insert(awardInstitutionDTO);
        return super.postResponse(result);
    }

    @PutMapping(name = "Update an award institution")
    public ResponseEntity<AwardInstitution> update(@RequestBody final AwardInstitution awardInstitution) {
        final AwardInstitution result = this.awardInstitutionService.update(awardInstitution);
        return super.putResponse(result);
    }

    @DeleteMapping(name = "Delete an award institution",
            value = "/{id}")
    public ResponseEntity<AwardInstitution> delete(@PathVariable final Long id) {
        final boolean result = this.awardInstitutionService.delete(id);
        return super.deleteResponse(result);
    }
}
