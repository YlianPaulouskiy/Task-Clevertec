package edu.clevertec.task.receipt.count;

import java.util.Map;

public interface Counter {

    Double getCost(Map<Long, Integer> products);

}
