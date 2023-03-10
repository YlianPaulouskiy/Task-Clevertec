package edu.clevertec.task.receipt.builder;

import edu.clevertec.task.receipt.converter.Converter;
import edu.clevertec.task.receipt.count.FullPriceCounter;
import edu.clevertec.task.receipt.count.SalePriceCounter;
import edu.clevertec.task.repository.DiscountCardRepository;
import edu.clevertec.task.repository.ProductRepository;

/**
 * Класс который создает чек со скидочной картой
 */
public class ReceiptWithSale extends ReceiptBuilder {

    private final Converter converter;
    private final FullPriceCounter fullPriceCounter;
    private final DiscountCardRepository cardRepository;

    public ReceiptWithSale(ProductRepository productRepository, DiscountCardRepository cardRepository) {
        this.cardRepository = cardRepository;
        converter = new Converter(productRepository);
        fullPriceCounter = new FullPriceCounter(productRepository);
    }

    @Override
    void buildProducts(String[] args) {
        receipt.setProducts(converter.getProducts(args));
    }

    @Override
    void buildSale(String[] args) {
        Integer cardNumber = converter.getDiscountCard(args);
        SalePriceCounter salePriceCounter = new SalePriceCounter(fullPriceCounter, cardNumber, cardRepository);
        Double totalPrice = fullPriceCounter.getCost(converter.getProductIds(args));
        Double salePrice = salePriceCounter.getCost(converter.getProductIds(args));
        receipt.setSale(totalPrice - salePrice);
    }

    @Override
    void buildTotal(String[] args) {
        receipt.setTotal(fullPriceCounter.getCost(converter.getProductIds(args)));
    }

    @Override
    void buildTotalWithSale(String[] args) {
        Integer cardNumber = converter.getDiscountCard(args);
        SalePriceCounter salePriceCounter = new SalePriceCounter(fullPriceCounter, cardNumber, cardRepository);
        receipt.setTotalWithSale(salePriceCounter.getCost(converter.getProductIds(args)));
    }
}
