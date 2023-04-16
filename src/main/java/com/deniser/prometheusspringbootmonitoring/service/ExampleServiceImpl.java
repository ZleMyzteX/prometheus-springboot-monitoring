package com.deniser.prometheusspringbootmonitoring.service;

import com.deniser.prometheusspringbootmonitoring.components.ExampleComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl implements ExampleService {
    public static final Logger LOGGER = LogManager.getLogger(ExampleServiceImpl.class);

    private final ExampleComponent exampleComponent;

    @Autowired
    public ExampleServiceImpl(ExampleComponent exampleComponent) {
        this.exampleComponent = exampleComponent;
    }

    @Override
    public String exception() throws RuntimeException {
        LOGGER.info("Throwing exception");
        LOGGER.error("Runtime exception thrown!");
        throw new RuntimeException("Exception from exception method.");
    }

    @Override
    public String incrementCounterOne() {
        LOGGER.info("Incrementing counter one");
        return exampleComponent.incrementCounterOne();
    }

    @Override
    public String incrementCounterOne(int amount) {
        LOGGER.info("Incrementing counter one with amount {}", amount);
        return exampleComponent.incrementCounterOne(amount);
    }

    @Override
    public String incrementCounterTwo() {
        LOGGER.info("Incrementing counter two");
        return exampleComponent.incrementCounterTwo();
    }

    @Override
    public String incrementCounterTwo(int amount) {
        LOGGER.info("Incrementing counter two with amount {}", amount);
        return exampleComponent.incrementCounterTwo(amount);
    }
}
