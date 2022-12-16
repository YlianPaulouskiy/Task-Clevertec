package edu.clevertec.task.receipt.builder;

import edu.clevertec.task.receipt.converter.Converter;
import edu.clevertec.task.receipt.count.FullPriceCounter;
import edu.clevertec.task.repository.ProductRepository;

public class ReceiptWithoutSale extends ReceiptBuilder {

    private final Converter converter;
    private final FullPriceCounter fullPriceCounter;

    public ReceiptWithoutSale(ProductRepository productRepository) {
        converter = new Converter(productRepository);
        fullPriceCounter = new FullPriceCounter(productRepository);
    }

    @Override
    void buildProducts(String[] args) {
        receipt.setProducts(converter.getProducts(args));
    }

    @Override
    void buildSale(String[] args) {
        receipt.setSale(null);
    }

    @Override
    void buildTotal(String[] args) {
        receipt.setTotal(fullPriceCounter.getCost(converter.getProductIds(args)));
    }

    @Override
    void buildTotalWithSale(String[] args) {
        receipt.setTotalWithSale(null);
    }
}
