package com.deniser.prometheusspringbootmonitoring.controller;

import com.deniser.prometheusspringbootmonitoring.service.ExampleServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    public static final Logger LOGGER = LogManager.getLogger(Controller.class);

    private final ExampleServiceImpl exampleService;

    @Autowired
    public Controller(ExampleServiceImpl exampleServ) {
        exampleService = exampleServ;
    }

    @RequestMapping("/test")
    public String test() {
        LOGGER.info("Requested test.");
        return "test-success!";
    }

    @RequestMapping("/exception")
    public String exception() throws RuntimeException {
        LOGGER.info("Requested exception, throwing exception.");
        return exampleService.exception();
    }

    @RequestMapping("/delay")
    public String returnWithDelay() throws InterruptedException {
        LOGGER.info("Requested standard delay");
        return exampleService.returnWithDelay();
    }

    @RequestMapping("/delay/{time}")
    public String returnWithCustomDelay(@PathVariable("time") int delay) throws InterruptedException {
        LOGGER.info("Requested delay with custom time {}ms", delay);
        return exampleService.returnWithCustomDelay(delay);
    }
}
