package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {
    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        logger.info("This message should appear in both the console and the file.");
        logger.warn("This is a warning that goes to both appenders.");
        logger.error("Error log captured in console and file appender.");
    }
}
