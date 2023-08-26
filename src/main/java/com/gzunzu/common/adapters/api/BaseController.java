package com.gzunzu.common.adapters.api;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class BaseController<D> {

    protected ResponseEntity<D> getResponse(final D dto) {
        return dto == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);
    }

    protected ResponseEntity<List<D>> getResponse(final List<D> dtoList) {
        return CollectionUtils.isEmpty(dtoList) ? ResponseEntity.noContent().build() : ResponseEntity.ok(dtoList);
    }

    protected ResponseEntity<D> postResponse(final D dto) {
        return dto == null ? ResponseEntity.internalServerError().build() : ResponseEntity.ok(dto);
    }

    protected ResponseEntity<D> putResponse(final D dto) {
        return dto == null ? ResponseEntity.internalServerError().build() : ResponseEntity.ok(dto);
    }

    protected ResponseEntity<D> deleteResponse(final boolean success) {
        return success ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
