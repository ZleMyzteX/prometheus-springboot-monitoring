package com.deniser.prometheusspringbootmonitoring.controller;

import com.deniser.prometheusspringbootmonitoring.service.DelayServiceImpl;
import com.deniser.prometheusspringbootmonitoring.service.ExampleServiceImpl;
import io.micrometer.core.annotation.Timed;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    public static final Logger LOGGER = LogManager.getLogger(Controller.class);

    private final ExampleServiceImpl exampleService;
    private final DelayServiceImpl delayService;

    @Autowired
    public Controller(ExampleServiceImpl exampleServ, DelayServiceImpl delayService) {
        this.exampleService = exampleServ;
        this.delayService = delayService;
    }

    @GetMapping("/test")
    public String test() {
        LOGGER.info("Requested test.");
        return "test-success!";
    }

    @GetMapping("/exception")
    public String exception() throws RuntimeException {
        LOGGER.info("Requested exception, throwing exception.");
        return exampleService.exception();
    }

    @GetMapping("/delay")
    @Timed("return-static-delay")
    public String returnWithDelay() throws InterruptedException {
        LOGGER.info("Requested standard delay");
        return delayService.returnWithDelay();
    }

    @GetMapping("/delay/{time}")
    @Timed("return-custom-delay")
    public String returnWithCustomDelay(@PathVariable("time") int delay) {
        LOGGER.info("Requested delay with custom time {}ms", delay);
        return delayService.returnWithCustomDelay(delay);
    }

    @PutMapping("/custom/one")
    @Timed("increment-counter-one")
    public String incrementCustomCounterOne() {
        LOGGER.info("Incrementing counter one");
        return exampleService.incrementCounterOne();
    }

    @PutMapping("/custom/one/{amount}")
    public String incrementCustomCounterOne(@PathVariable("amount") int amount) {
        LOGGER.info("Incrementing counter one with amount {}", amount);
        return exampleService.incrementCounterOne(amount);
    }

    @PutMapping("/custom/two")
    @Timed("increment-counter-two")
    public String incrementCustomCounterTwo() {
        LOGGER.info("Incrementing counter two");
        return exampleService.incrementCounterTwo();
    }

    @PutMapping("/custom/two/{amount}")
    public String incrementCustomCounterTwo(@PathVariable("amount") int amount) {
        LOGGER.info("Incrementing counter two with amount {}", amount);
        return exampleService.incrementCounterTwo(amount);
    }
}
