package com.riwi.library.domain.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

public interface ServiceBase <RequestDTO, ResponseDTO, ID>{
    ResponseDTO create(RequestDTO request);

    ResponseDTO get(ID id);

    Page<ResponseDTO> getAll(int page, int size);

    ResponseDTO update(ID id, RequestDTO request);

    void delete(ID id);
}
