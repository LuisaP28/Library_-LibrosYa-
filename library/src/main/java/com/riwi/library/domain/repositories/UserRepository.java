package com.riwi.library.domain.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.library.domain.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUsername(String username);
}
