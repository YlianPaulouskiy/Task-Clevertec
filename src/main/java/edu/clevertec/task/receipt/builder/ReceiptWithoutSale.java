package edu.clevertec.task.receipt.builder;

import edu.clevertec.task.receipt.converter.Converter;
import edu.clevertec.task.receipt.count.FullPriceCounter;
import edu.clevertec.task.repository.DiscountCardRepository;
import edu.clevertec.task.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ReceiptWithoutSale extends ReceiptBuilder {

    private final Converter converter;
    private final FullPriceCounter fullPriceCounter;
    @Autowired
    private DiscountCardRepository cardRepository;
    @Autowired
    private ProductRepository productRepository;

    public ReceiptWithoutSale() {
        converter = new Converter();
        fullPriceCounter = new FullPriceCounter(productRepository);
    }


    @Override
    void buildProducts(String source) {
        receipt.setProducts(converter.getProducts(source));
    }

    @Override
    void buildSale(String source) {
        receipt.setSale(null);
    }

    @Override
    void buildTotal(String source) {
        receipt.setTotal(fullPriceCounter.getCost(converter.getProducts(source)));
    }

    @Override
    void buildTotalWithSale(String source) {
        receipt.setTotalWithSale(null);
    }
}
