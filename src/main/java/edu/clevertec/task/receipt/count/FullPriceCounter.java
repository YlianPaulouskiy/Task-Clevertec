package edu.clevertec.task.receipt.count;

import edu.clevertec.task.receipt.exception.ProductNotFoundException;
import edu.clevertec.task.model.Product;
import edu.clevertec.task.repository.ProductRepository;
//import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
//@AllArgsConstructor
public class FullPriceCounter implements Counter {

    private final ProductRepository productRepository;

    public FullPriceCounter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Double getCost(Map<Long, Integer> products) {
        double price = 0.0;
        for (Long id: products.keySet()) {
            if (productRepository.existsById(id)) {
                Product product = productRepository.getReferenceById(id);
                // скидка 10% на товары количество которых > 5
                if (products.get(id) > 5) {
                    price += product.getPrice()*0.1*products.get(id);
                } else  {
                    price += product.getPrice()*products.get(id);
                }
            }
            else {
                throw new ProductNotFoundException("Product " + id + " not founded.");
            }
        }
        return price;
    }
}
