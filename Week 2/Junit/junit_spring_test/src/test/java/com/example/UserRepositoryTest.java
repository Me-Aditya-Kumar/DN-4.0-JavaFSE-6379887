package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
        userRepository.save(new User(1L, "Alice"));
        userRepository.save(new User(2L, "Bob"));
        userRepository.save(new User(3L, "Alice")); // Same name
    }

    @Test
    void testFindByName() {
        List<User> result = userRepository.findByName("Alice");

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(user -> user.getName().equals("Alice")));
    }
}
