package edu.clevertec.task.receipt.builder;

import edu.clevertec.task.model.Receipt;

public class Director {

    private final ReceiptBuilder builder;

    public Director(ReceiptBuilder builder) {
        this.builder = builder;
    }

    public Receipt buildReceipt(String source) {
        builder.createReceipt();
        builder.buildProducts(source);
        builder.buildSale(source);
        builder.buildTotal(source);
        builder.buildTotal(source);
        return builder.getReceipt();
    }
    
}
