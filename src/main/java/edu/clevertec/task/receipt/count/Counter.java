package edu.clevertec.task.receipt.count;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Общий интерфейс для подсчета стоимости
 */
@Component
public interface Counter {

    /**
     * Метод для подсчета стоимости
     *
     * @param products карта(ключ = id продукта, значением = количеству)
     * @return стоимость
     */
    Double getCost(Map<Long, Integer> products);

}
