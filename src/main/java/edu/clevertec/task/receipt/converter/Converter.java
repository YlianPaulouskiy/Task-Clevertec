package edu.clevertec.task.receipt.converter;

import edu.clevertec.task.model.Product;
import edu.clevertec.task.receipt.exception.ProductNotFoundException;
import edu.clevertec.task.receipt.lines.LineCheck;
import edu.clevertec.task.receipt.lines.LineParsing;
import edu.clevertec.task.repository.ProductRepository;

import java.util.HashMap;
import java.util.Map;

public class Converter {

    private final ProductRepository productRepository;

    public Converter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Map<Long, Integer> getProductIds(String[] args) {
        Map<Long, Integer> products = new HashMap<>();
        for (String element : args) {
            if (!LineCheck.isCardSource(element)) { //откидываем элемент с дисконтной картой
                products.put(
                        Long.valueOf(LineParsing.getLeftPart(element)),
                        Integer.valueOf(LineParsing.getRightPart(element))
                );
            }
        }
        return products;
    }

    public Integer getDiscountCard(String[] args) {
        for (String element : args) {
            if (LineCheck.isCardSource(element)) { //находим элемент с дисконтной картой
                return Integer.valueOf(element);
            }
        }
        return null;
    }

    public Map<Product, Integer> getProducts(String[] args) {
        Map<Long, Integer> productsIds = getProductIds(args);
        Map<Product, Integer> products = new HashMap<>();
        for (Long productId : productsIds.keySet()) {
            if (productRepository.existsById(productId)) {
                products.put(
                        productRepository.getReferenceById(productId),
                        productsIds.get(productId)
                );
            } else {
                throw new ProductNotFoundException("Product " + productId + " not founded.");
            }
        }
        return products;
    }

}
