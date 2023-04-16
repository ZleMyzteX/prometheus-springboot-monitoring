package com.deniser.prometheusspringbootmonitoring.service;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DelayServiceImpl implements DelayService {
    public static final Logger LOGGER = LogManager.getLogger(DelayServiceImpl.class);
    private static final String DELAY_SUCCESS_MESSAGE = "delay success!";

    private final MeterRegistry meterRegistry;

    @Autowired
    public DelayServiceImpl(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
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

}
