package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EvenCheckerTest {

    private final EvenChecker checker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10, 0, -2})
    public void testEvenNumbers(int number) {
        assertTrue(checker.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9, -1, -3})
    public void testOddNumbers(int number) {
        assertFalse(checker.isEven(number));
    }
}
