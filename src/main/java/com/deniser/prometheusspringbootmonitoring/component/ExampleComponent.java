package com.deniser.prometheusspringbootmonitoring.component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class ExampleComponent {

    private Counter exampleOneCounter;
    private Counter exampleTwoCounter;

    private final MeterRegistry meterRegistry;

    public ExampleComponent(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        initCounters();
    }

    private void initCounters() {
        // Name=exampleO, type=one
        this.exampleOneCounter = this.meterRegistry.counter("example", "type", "one");
        // Name=exampleO, type=two
        this.exampleTwoCounter = this.meterRegistry.counter("example", "type", "two");
    }

    public String incrementCounterOne() {
        exampleOneCounter.increment();
        return "incremented counter one! Current value: " + exampleOneCounter.count();
    }

    public String incrementCounterOne(int count) {
        exampleOneCounter.increment(count);
        return "incremented counter one with custom value " + count + "! Current value: " + exampleOneCounter.count();
    }

    public String incrementCounterTwo() {
        exampleTwoCounter.increment();
        return "incremented counter two! Current value: " + exampleTwoCounter.count();
    }

    public String incrementCounterTwo(int count) {
        exampleTwoCounter.increment(count);
        return "incremented counter two with custom value " + count + "! current value: " + exampleTwoCounter.count();
    }
}
