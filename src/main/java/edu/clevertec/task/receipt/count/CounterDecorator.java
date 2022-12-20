package edu.clevertec.task.receipt.count;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Класс для реализации интерфейса Counter и
 * реализации паттерна Decorator
 */
@Component
@AllArgsConstructor
public class CounterDecorator implements Counter {

    private final Counter counter;

    @Override
    public Double getCost(Map<Long, Integer> products) {
        return counter.getCost(products);
    }
}
