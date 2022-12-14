package edu.clevertec.task.receipt.exception;

public class DiscountCardNotFoundException extends RuntimeException {
    public DiscountCardNotFoundException() {
        this("Discount card not founded.");
    }

    public DiscountCardNotFoundException(String message) {
        super(message);
    }
}
