package edu.clevertec.task.receipt.builder;

import edu.clevertec.task.model.Receipt;

public class Director {

    private final ReceiptBuilder builder;

    public Director(ReceiptBuilder builder) {
        this.builder = builder;
    }

    public Receipt buildReceipt(String[] args) {
        builder.createReceipt();
        builder.buildProducts(args);
        builder.buildSale(args);
        builder.buildTotal(args);
        builder.buildTotalWithSale(args);
        return builder.getReceipt();
    }
    
}
