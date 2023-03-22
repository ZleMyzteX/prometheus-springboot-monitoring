package com.deniser.prometheusspringbootmonitoring.service;

import com.deniser.prometheusspringbootmonitoring.components.ExampleComponent;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl implements ExampleService {
    public static final Logger LOGGER = LogManager.getLogger(ExampleServiceImpl.class);
    private static final String DELAY_SUCCESS_MESSAGE = "delay success!";

    private final ExampleComponent exampleComponent;
    private final MeterRegistry meterRegistry;

    @Autowired
    public ExampleServiceImpl(ExampleComponent exampleComponent, MeterRegistry meterRegistry) {
        this.exampleComponent = exampleComponent;
        this.meterRegistry = meterRegistry;
    }

    @Override
    public String exception() throws RuntimeException {
        LOGGER.info("Throwing exception");
        LOGGER.error("Runtime exception thrown!");
        throw new RuntimeException("Exception from exception method.");
    }

    @Override
    public String returnWithDelay() throws InterruptedException {
        LOGGER.info("Requested delay, waiting 1000ms");
        Thread.sleep(1000);
        LOGGER.info("Delay over, returning.");
        return DELAY_SUCCESS_MESSAGE;
    }

    @Override
    public String returnWithCustomDelay(int delay) {
        LOGGER.info("Requested custom delay at {}ms, waiting...", delay);
        Timer timer = meterRegistry.timer(this.getClass().getSimpleName() + ".doWork");
        timer.record(() -> {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        LOGGER.info("Delay over, returning.");
        return DELAY_SUCCESS_MESSAGE;
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
