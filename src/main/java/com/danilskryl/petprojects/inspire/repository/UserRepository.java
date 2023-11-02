package com.danilskryl.petprojects.inspire.repository;

import com.danilskryl.petprojects.inspire.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}
