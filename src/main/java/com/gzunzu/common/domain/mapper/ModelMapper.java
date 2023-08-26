package com.gzunzu.common.domain.mapper;

public interface ModelMapper<E, D> {

    D toDto(final E entity);

    E fromDto(final D dto);
}
