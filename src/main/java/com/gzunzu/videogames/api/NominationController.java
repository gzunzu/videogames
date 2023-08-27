package com.gzunzu.videogames.api;

import com.gzunzu.common.adapters.api.BaseController;
import com.gzunzu.videogames.domain.dto.NominationDTO;
import com.gzunzu.videogames.ports.NominationService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "Nominations controller",
        path = "api/1.0/nominations",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class NominationController extends BaseController<NominationDTO> {

    private final NominationService nominationService;

    @GetMapping(name = "Get all nominations")
    public ResponseEntity<List<NominationDTO>> getAll() {
        final List<NominationDTO> result = this.nominationService.getAll();
        return super.getResponse(result);
    }

    @GetMapping(name = "Get a nomination by ID",
            value = "/{id}")
    public ResponseEntity<NominationDTO> getById(@PathVariable(name = "id") final long id) {
        final NominationDTO result = this.nominationService.getById(id);
        return super.getResponse(result);
    }

    @GetMapping(name = "Get all nominations by institution and category (optional)",
            value = "/search")
    public ResponseEntity<List<NominationDTO>> getByCategoryAndInstitution(@RequestParam(value = "institution") final String institution,
                                                                           @RequestParam(value = "category", required = false) final String category) {
        final List<NominationDTO> result = StringUtils.isEmpty(category) ?
                this.nominationService.getByInstitutionName(institution)
                : this.nominationService.getByInstitutionNameAndCategoryName(institution, category);
        return super.getResponse(result);
    }

    @GetMapping(name = "Get all nominations by video game title",
            value = "/videogame/{videoGameId}")
    public ResponseEntity<List<NominationDTO>> getByVideoGameId(@PathVariable(value = "videoGameId") final Long videoGameId) {
        final List<NominationDTO> result = this.nominationService.getByVideoGameId(videoGameId);
        return super.getResponse(result);
    }

    @PostMapping(name = "Insert a nomination",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NominationDTO> insert(@RequestBody final NominationDTO nominationDTO) {
        final NominationDTO result = this.nominationService.insert(nominationDTO);
        return super.postResponse(result);
    }

    @PutMapping(name = "Update a nomination",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NominationDTO> update(@RequestBody final NominationDTO nominationDTO) {
        final NominationDTO result = this.nominationService.update(nominationDTO);
        return super.putResponse(result);
    }

    @DeleteMapping(name = "Delete a nomination by ID",
            value = "/{id}",
            produces = MediaType.ALL_VALUE)
    public ResponseEntity<NominationDTO> delete(@PathVariable final Long id) {
        final boolean result = this.nominationService.delete(id);
        return super.deleteResponse(result);
    }
}
