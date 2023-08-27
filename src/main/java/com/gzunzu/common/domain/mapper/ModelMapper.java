package com.gzunzu.common.domain.mapper;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface ModelMapper<E, D> {

    D toDto(final E entity);

    E fromDto(final D dto);

    default Function<List<E>, List<D>> toDto() {
        return (List<E> entities) -> CollectionUtils.emptyIfNull(entities).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    default Function<List<D>, List<E>> fromDto() {
        return (List<D> dtos) -> CollectionUtils.emptyIfNull(dtos).stream()
                .map(this::fromDto)
                .collect(Collectors.toList());
    }
}
