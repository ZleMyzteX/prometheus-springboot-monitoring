package com.deniser.prometheusspringbootmonitoring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
    private RestTemplate restTemplate;

    @RequestMapping("/test")
    public String test() {
        return "test-success!";
    }
}
