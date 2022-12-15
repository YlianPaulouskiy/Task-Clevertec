package edu.clevertec.task.receipt.builder;

import edu.clevertec.task.receipt.converter.Converter;
import edu.clevertec.task.receipt.count.FullPriceCounter;
import edu.clevertec.task.receipt.count.SalePriceCounter;
import edu.clevertec.task.repository.DiscountCardRepository;
import edu.clevertec.task.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ReceiptWithSale extends ReceiptBuilder {

    private final Converter converter;
    private final FullPriceCounter fullPriceCounter;
    @Autowired
    private DiscountCardRepository cardRepository;
    @Autowired
    private ProductRepository productRepository;

    public ReceiptWithSale() {
        converter = new Converter(productRepository);
        fullPriceCounter = new FullPriceCounter(productRepository);
    }

    @Override
    void buildProducts(String source) {
        receipt.setProducts(converter.getProducts(source));
    }

    @Override
    void buildSale(String source) {
        Integer cardNumber = converter.getDiscountCard(source);
        SalePriceCounter salePriceCounter = new SalePriceCounter(fullPriceCounter, cardNumber, cardRepository);
        Double totalPrice = fullPriceCounter.getCost(converter.getProductIds(source));
        Double salePrice = salePriceCounter.getCost(converter.getProductIds(source));
        receipt.setSale(totalPrice - salePrice);
    }

    @Override
    void buildTotal(String source) {
        receipt.setTotal(fullPriceCounter.getCost(converter.getProductIds(source)));
    }

    @Override
    void buildTotalWithSale(String source) {
        Integer cardNumber = converter.getDiscountCard(source);
        SalePriceCounter salePriceCounter = new SalePriceCounter(fullPriceCounter, cardNumber, cardRepository);
        receipt.setTotalWithSale(salePriceCounter.getCost(converter.getProductIds(source)));
    }
}
