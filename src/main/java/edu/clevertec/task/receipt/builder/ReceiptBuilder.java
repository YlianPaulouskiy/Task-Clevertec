package edu.clevertec.task.receipt.builder;

import edu.clevertec.task.model.Receipt;

public abstract class ReceiptBuilder {

    protected Receipt receipt;

    public void createReceipt() {
        receipt = new Receipt();
    }

    abstract void buildProducts(String[] args);

    abstract void buildSale(String[] args);

    abstract void buildTotal(String[] args);

    abstract void buildTotalWithSale(String[] args);

    public Receipt getReceipt() {
        return receipt;
    }

}
