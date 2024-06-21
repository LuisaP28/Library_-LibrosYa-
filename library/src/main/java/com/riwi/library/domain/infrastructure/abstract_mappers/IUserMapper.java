package com.riwi.library.domain.infrastructure.abstract_mappers;

import com.riwi.library.api.dto.get_all.UserResponse;
import com.riwi.library.api.dto.request.UserRequest;
import com.riwi.library.domain.entities.User;

public interface IUserMapper extends MapperBase<UserRequest, User, UserResponse> {
    
}
