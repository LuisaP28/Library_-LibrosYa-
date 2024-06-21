package com.riwi.library.api.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface ControllerBase <RequestDTO, ResponseDTO, ID> {
    ResponseEntity<ResponseDTO> create(RequestDTO request);

    ResponseEntity<ResponseDTO> get(ID id);

    ResponseEntity<Page<ResponseDTO>> getAll(int page, int size);

    ResponseEntity<ResponseDTO> update(RequestDTO request, ID id);

    ResponseEntity<Void> delete(ID id);
}
