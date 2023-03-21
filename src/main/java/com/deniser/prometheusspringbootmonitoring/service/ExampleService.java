package com.deniser.prometheusspringbootmonitoring.service;

public interface ExampleService {

    /**
     * Simply throws a RuntimeException.
     * Will never return anything.
     */
    String exception() throws RuntimeException;

    /**
     * Returns DELAY_SUCCESS_MESSAGE with a fixed delay of 1000ms.
     *
     * @return always DELAY_SUCCESS_MESSAGE
     */
    String returnWithDelay() throws InterruptedException;

    /**
     * Returns DELAY_SUCCESS_MESSAGE with the given delay.
     *
     * @return always DELAY_SUCCESS_MESSAGE
     */
    String returnWithCustomDelay(int delay) throws InterruptedException;

    /**
     * Increments exampleCounter (type one) from ExampleComponent.
     */
    String incrementCounterOne();

    /**
     * Increments exampleCounter (type one) from ExampleComponent with the given value.
     */
    String incrementCounterOne(int amount);

    /**
     * Increments exampleCounter (type two) from ExampleComponent.
     */
    String incrementCounterTwo();

    /**
     * Increments exampleCounter (type two) from ExampleComponent with the given value.
     */
    String incrementCounterTwo(int amount);
}
