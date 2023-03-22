package com.deniser.prometheusspringbootmonitoring;

import com.deniser.prometheusspringbootmonitoring.service.ExampleServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class PrometheusSpringbootMonitoringApplicationTests {
    @Autowired
    private ExampleServiceImpl exampleService;

    @DisplayName("Exception throws RuntimeException with custom message.")
    @Test
    void exceptionShouldThrowRuntimeException() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> exampleService.exception());
        assertEquals("Exception from exception method.", exception.getMessage());
    }
}
