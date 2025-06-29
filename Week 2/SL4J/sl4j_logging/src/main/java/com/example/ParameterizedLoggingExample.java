package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "Aditya";
        int attempts = 3;

        logger.info("User {} has attempted login {} times", username, attempts);

        double amount = 2500.75;
        logger.debug("Transaction amount: ${}", amount);
    }
}
