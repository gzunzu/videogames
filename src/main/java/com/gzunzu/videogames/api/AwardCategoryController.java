package com.gzunzu.videogames.api;

import com.gzunzu.common.adapters.api.BaseController;
import com.gzunzu.videogames.domain.dto.AwardCategoryDTO;
import com.gzunzu.videogames.ports.AwardCategoryService;
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
@RequestMapping(name = "Award categories controller",
        path = "api/1.0/categories",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AwardCategoryController extends BaseController<AwardCategoryDTO> {

    private final AwardCategoryService awardCategoryService;

    @GetMapping(name = "Get all award categories")
    public ResponseEntity<List<AwardCategoryDTO>> getAll() {
        final List<AwardCategoryDTO> result = this.awardCategoryService.getAll();
        return super.getResponse(result);
    }

    @GetMapping(name = "Get an award category by ID",
            value = "/{id}")
    public ResponseEntity<AwardCategoryDTO> getById(@PathVariable(name = "id") final long id) {
        final AwardCategoryDTO result = this.awardCategoryService.getById(id);
        return super.getResponse(result);
    }

    @GetMapping(name = "Get an award category by name and institution name",
            value = "/search")
    public ResponseEntity<List<AwardCategoryDTO>> getByNameAndInstitution(@RequestParam(value = "institution") final String institution,
                                                                          @RequestParam(name = "name", required = false) final String name) {
        final List<AwardCategoryDTO> result = StringUtils.isEmpty(name) ?
                this.awardCategoryService.getByInstitutionName(institution)
                : this.awardCategoryService.getByInstitutionNameAndCategoryName(institution, name);
        return super.getResponse(result);
    }

    @PostMapping(name = "Insert an award category",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AwardCategoryDTO> insert(@RequestBody final AwardCategoryDTO awardCategoryDTO) {
        final AwardCategoryDTO result = this.awardCategoryService.insert(awardCategoryDTO);
        return super.postResponse(result);
    }

    @PutMapping(name = "Update an award category",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AwardCategoryDTO> update(@RequestBody final AwardCategoryDTO awardCategoryDTO) {
        final AwardCategoryDTO result = this.awardCategoryService.update(awardCategoryDTO);
        return super.putResponse(result);
    }

    @DeleteMapping(name = "Delete an award category by ID",
            value = "/{id}",
            produces = MediaType.ALL_VALUE)
    public ResponseEntity<AwardCategoryDTO> delete(@PathVariable final Long id) {
        final boolean result = this.awardCategoryService.delete(id);
        return super.deleteResponse(result);
    }
}
