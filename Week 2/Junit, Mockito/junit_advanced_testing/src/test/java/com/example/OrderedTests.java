package com.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(3)
    void testC() {
        System.out.println("Running testC");
        assertTrue(5 > 1);
    }

    @Test
    @Order(1)
    void testA() {
        System.out.println("Running testA");
        assertEquals(10, 5 + 5);
    }

    @Test
    @Order(2)
    void testB() {
        System.out.println("Running testB");
        assertFalse(3 > 5);
    }
}
