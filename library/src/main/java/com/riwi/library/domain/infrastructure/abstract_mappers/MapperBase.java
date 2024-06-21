package com.riwi.library.domain.infrastructure.abstract_mappers;

public interface MapperBase <RequestDTO, Entity ,ResponseDTO> {
    Entity requestToEntity(RequestDTO request);

    ResponseDTO entityToResponse(Entity entity);
}
