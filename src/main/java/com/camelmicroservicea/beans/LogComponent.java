package com.camelmicroservicea.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogComponent {
    public static final Logger logger = LoggerFactory.getLogger(LogComponent.class);

    public void log(String message) {
        logger.info("{}", message);
    }
}