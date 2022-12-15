package edu.clevertec.task.receipt.builder;

import edu.clevertec.task.model.Receipt;

public abstract class ReceiptBuilder {

    protected Receipt receipt;

    public void createReceipt() {
        receipt = new Receipt();
    }

    abstract void buildProducts(String source);

    abstract void buildSale(String source);

    abstract void buildTotal(String source);

    abstract void buildTotalWithSale(String source);

    public Receipt getReceipt() {
        return receipt;
    }

}
