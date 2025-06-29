package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    @Test
    void testAddition() {
        assertEquals(10, 5 + 5);
    }

    @Test
    void testMultiplication() {
        assertEquals(25, 5 * 5);
    }
}
