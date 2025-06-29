package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

// Make sure this interface matches your User entity package and name
public interface UserRepository extends JpaRepository<User, Long> {
}