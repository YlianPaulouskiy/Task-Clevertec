package edu.clevertec.task.receipt.exception;

/**
 * Исключение в случае, если продукта нет в базе
 */
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        this("Product not founded.");
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
