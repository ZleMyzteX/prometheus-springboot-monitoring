package com.deniser.prometheusspringbootmonitoring.service;

public interface DelayService {
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

}
