package com.deniser.prometheusspringbootmonitoring.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl implements ExampleService {
    public static final Logger LOGGER = LogManager.getLogger(ExampleServiceImpl.class);
    private static final String DELAY_SUCCESS_MESSAGE = "delay success!";

    @Override
    public String exception() throws RuntimeException {
        LOGGER.info("Throwing exception");

        throw new RuntimeException();
    }

    @Override
    public String returnWithDelay() throws InterruptedException {
        LOGGER.info("Requested delay, waiting 1000ms");
        Thread.sleep(1000);
        LOGGER.info("Delay over, returning.");
        return DELAY_SUCCESS_MESSAGE;
    }

    @Override
    public String returnWithCustomDelay(int delay) throws InterruptedException {
        LOGGER.info("Requested custom delay at {}ms, waiting...", delay);
        Thread.sleep(delay);
        LOGGER.info("Delay over, returning.");
        return DELAY_SUCCESS_MESSAGE;
    }


}
