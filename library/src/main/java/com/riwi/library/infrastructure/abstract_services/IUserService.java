package com.riwi.library.infrastructure.abstract_services;

import com.riwi.library.api.dto.get_all.UserResponse;
import com.riwi.library.api.dto.request.UserRequest;
import com.riwi.library.domain.infrastructure.abstract_services.ServiceBase;

public interface IUserService  extends ServiceBase<UserRequest, UserResponse, Long> {
    
}
