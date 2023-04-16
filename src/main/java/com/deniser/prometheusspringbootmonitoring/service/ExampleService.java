package com.deniser.prometheusspringbootmonitoring.service;

public interface ExampleService {

    /**
     * Simply throws a RuntimeException.
     * Will never return anything.
     */
    String exception() throws RuntimeException;

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
