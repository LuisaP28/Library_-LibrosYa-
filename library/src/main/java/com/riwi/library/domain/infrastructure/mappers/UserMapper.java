package com.riwi.library.domain.infrastructure.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.riwi.library.api.dto.get_all.UserResponse;
import com.riwi.library.api.dto.request.UserRequest;
import com.riwi.library.domain.entities.User;
import com.riwi.library.domain.infrastructure.abstract_mappers.IUserMapper;
import com.riwi.library.domain.repositories.UserRepository;
import com.riwi.library.util.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserMapper implements IUserMapper{
    @Autowired
    private final UserRepository userRepository;

    @Override
    public User requestToEntity(UserRequest request) {

        User email = this.userRepository.findByEmail(request.getEmail());
        User username = this.userRepository.findByUsername(request.getUsername());
        
        if ( email != null && !email.getEmail().equalsIgnoreCase(request.getEmail())) {
            throw new BadRequestException("E-mail is already registered"+ email.getEmail());
        };

        if ( username != null && !username.getUsername().equals(request.getUsername())) {
            throw new BadRequestException("Username is already registered");
        };

        return User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .fullName(request.getFullName())
                .role(request.getRole())
                .build();
    }

    @Override
    public UserResponse entityToResponse(User entity) {
        return UserResponse.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .email(entity.getEmail())
                .fullName(entity.getFullName())
                .role(entity.getRole())
                .build();
    }

}
