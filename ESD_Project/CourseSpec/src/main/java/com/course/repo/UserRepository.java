package com.course.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query to find a user by username
    Optional<User> findByUsername(String username);
}
