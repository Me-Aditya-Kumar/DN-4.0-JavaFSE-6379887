package com.cognizant.spring_learn.repository;

import com.cognizant.spring_learn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
