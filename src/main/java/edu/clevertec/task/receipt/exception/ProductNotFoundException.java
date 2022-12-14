package edu.clevertec.task.receipt.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        this("Product not founded.");
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
