package edu.clevertec.task.receipt.exception;

/**
 * Исключение в случае, если скидочной карты нету в базе
 */
public class DiscountCardNotFoundException extends RuntimeException {

    public DiscountCardNotFoundException() {
        this("Discount card not founded.");
    }

    public DiscountCardNotFoundException(String message) {
        super(message);
    }
}
