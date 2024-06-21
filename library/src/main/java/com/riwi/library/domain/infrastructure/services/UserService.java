package com.riwi.library.domain.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.library.api.dto.get_all.UserResponse;
import com.riwi.library.api.dto.request.UserRequest;
import com.riwi.library.domain.entities.User;
import com.riwi.library.domain.infrastructure.abstract_mappers.IUserMapper;
import com.riwi.library.domain.repositories.UserRepository;
import com.riwi.library.infrastructure.abstract_services.IUserService;
import com.riwi.library.infrastructure.helpers.ServiceHelper;
import com.riwi.library.util.enums.Role;
import com.riwi.library.util.exceptions.BadRoleException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService{
    
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final ServiceHelper serviceHelper;

    @Autowired
    private final IUserMapper userMapper;

    @Override
    public UserResponse create(UserRequest request) {
        if (request.getRole() == null) {
            throw new BadRoleException("REQUIRED");
        }

        try {
            Role.valueOf(request.getRole().name());
        } catch (Exception e) {
            throw new BadRoleException("INVALID");
        }

        User user = this.userMapper.requestToEntity(request);
        return this.userMapper.entityToResponse(this.userRepository.save(user));
    }

    @Override
    public UserResponse get(Long id) {
        User user = this.serviceHelper.find(id, userRepository, "user");
        return this.userMapper.entityToResponse(user);
    }

    @Override
    public Page<UserResponse> getAll(int page, int size) {
        if (page < 0) page = 0;
        if (size < 1) size = 10;

        return this.userRepository.findAll(PageRequest.of(page, size))
                .map((entity) -> this.userMapper.entityToResponse(entity));
    }

    @Override
    public UserResponse update(Long id, UserRequest request) {
        User userData = this.serviceHelper.find(id, userRepository, "user");

        if (userData.getRole() == Role.ADMIN) {
            try {
                if (request.getRole() != null) {
                    Role.valueOf(request.getRole().name());
                }
            } catch (Exception e) {
                throw new BadRoleException("INVALID");
            }
        } else {
            if (request.getRole() != null) {
                throw new BadRoleException("NOT ALLOWED");
            }
        }

        if (request.getRole() == null) {
            request.setRole(userData.getRole());
        }

        User user = this.userMapper.requestToEntity(request);
        user.setId(id);

        return this.userMapper.entityToResponse(this.userRepository.save(user));
    }

    @Override
    public void delete(Long id) {
        User user = this.serviceHelper.find(id, userRepository, "user");
        this.userRepository.delete(user);
    }
}
