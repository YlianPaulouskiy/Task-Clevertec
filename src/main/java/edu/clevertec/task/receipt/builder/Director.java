package edu.clevertec.task.receipt.builder;

import edu.clevertec.task.model.Receipt;
import lombok.AllArgsConstructor;

/**
 * Класс который определяет порядок создания чека
 */
@AllArgsConstructor
public class Director {

    private final ReceiptBuilder builder;

    /**
     * Создает чек
     *
     * @param args входные аргументы
     * @return Receipt
     */
    public Receipt buildReceipt(String[] args) {
        builder.createReceipt();
        builder.buildMarket();
        builder.buildProducts(args);
        builder.buildSale(args);
        builder.buildTotal(args);
        builder.buildTotalWithSale(args);
        builder.buildDate();
        builder.buildTime();
        return builder.getReceipt();
    }

}
