package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    @Test
    public void testExceptionIsThrown() {
        ExceptionThrower thrower = new ExceptionThrower();

        assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException(true);
        });
    }

    @Test
    public void testNoException() {
        ExceptionThrower thrower = new ExceptionThrower();

        assertDoesNotThrow(() -> {
            thrower.throwException(false);
        });
    }
}
