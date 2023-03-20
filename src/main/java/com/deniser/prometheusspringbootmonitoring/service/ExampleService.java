package com.deniser.prometheusspringbootmonitoring.service;

public interface ExampleService {

    String exception() throws RuntimeException;

    String returnWithDelay() throws InterruptedException;

    String returnWithCustomDelay(int delay) throws InterruptedException;
}
