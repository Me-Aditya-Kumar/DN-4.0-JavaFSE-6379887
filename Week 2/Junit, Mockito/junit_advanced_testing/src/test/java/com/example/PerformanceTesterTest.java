package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

public class PerformanceTesterTest {

    @Test
    public void testTaskCompletesWithinTime() {
        PerformanceTester tester = new PerformanceTester();

        assertTimeout(Duration.ofMillis(1000), () -> {
            tester.performTask();
        });
    }

    @Test
    public void testFailsIfTaskTooSlow() {
        PerformanceTester tester = new PerformanceTester();

        assertTimeoutPreemptively(Duration.ofMillis(300), () -> {
    new PerformanceTester().performTask();
});
    }
}
