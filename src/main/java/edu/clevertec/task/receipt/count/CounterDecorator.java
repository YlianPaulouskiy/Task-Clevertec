package edu.clevertec.task.receipt.count;

import java.util.Map;

public class CounterDecorator implements Counter {

    private final Counter counter;

    public CounterDecorator(Counter counter) {
        this.counter = counter;
    }

    @Override
    public Double getCost(Map<Long, Integer> products) {
        return counter.getCost(products);
    }
}
