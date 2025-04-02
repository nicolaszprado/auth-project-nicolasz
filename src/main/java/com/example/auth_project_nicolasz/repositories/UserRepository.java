package com.example.auth_project_nicolasz.repositories;

import com.example.auth_project_nicolasz.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {


    Optional<User> findByEmail(String email);
}
