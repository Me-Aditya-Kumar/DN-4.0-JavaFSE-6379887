package com.example;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calc;

    @Before
    public void setUp() {
        calc = new Calculator();
        System.out.println("Setup complete");
    }

    @After
    public void tearDown() {
        calc = null;
        System.out.println("Teardown complete");
    }

    @Test
    public void testAdd() {
        int result = calc.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testIsEven() {
        assertTrue(calc.isEven(8));
        assertFalse(calc.isEven(7));
    }
}
