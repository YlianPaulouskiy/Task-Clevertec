package edu.clevertec.task.receipt.builder;

import edu.clevertec.task.model.Receipt;

/**
 * Класс который определяет порядок создания чека
 */
public class Director {

    private final ReceiptBuilder builder;

    public Director(ReceiptBuilder builder) {
        this.builder = builder;
    }

    /**
     * Создает чек
     *
     * @param args входные аргументы
     * @return Receipt
     */
    public Receipt buildReceipt(String[] args) {
        builder.createReceipt();
        builder.buildProducts(args);
        builder.buildSale(args);
        builder.buildTotal(args);
        builder.buildTotalWithSale(args);
        return builder.getReceipt();
    }

}
