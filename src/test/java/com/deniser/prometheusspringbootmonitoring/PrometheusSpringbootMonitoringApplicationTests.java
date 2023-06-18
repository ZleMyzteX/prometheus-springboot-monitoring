package com.deniser.prometheusspringbootmonitoring;

import com.deniser.prometheusspringbootmonitoring.service.ExampleServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ExtendWith(SpringExtension.class)
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
