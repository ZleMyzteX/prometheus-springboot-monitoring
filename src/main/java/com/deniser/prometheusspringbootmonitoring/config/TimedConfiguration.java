package com.deniser.prometheusspringbootmonitoring.config;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class TimedConfiguration {
    /**
     * This is required so that we can use the @Timed annotation
     * on methods that we want to time.
     * See: <a href="https://micrometer.io/docs/concepts#_the_timed_annotation">...</a>
     */
    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }
}