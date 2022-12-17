package edu.clevertec.task.service;

import edu.clevertec.task.model.Receipt;
import edu.clevertec.task.receipt.builder.Director;
import edu.clevertec.task.receipt.builder.ReceiptBuilder;
import edu.clevertec.task.receipt.builder.ReceiptWithSale;
import edu.clevertec.task.receipt.builder.ReceiptWithoutSale;
import edu.clevertec.task.receipt.converter.Converter;
import edu.clevertec.task.receipt.lines.LineCheck;
import edu.clevertec.task.receipt.writer.ReceiptWriter;
import edu.clevertec.task.repository.DiscountCardRepository;
import edu.clevertec.task.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ReceiptService {

    private final ProductRepository productRepository;
    private final DiscountCardRepository cardRepository;

    public ReceiptService(ProductRepository productRepository, DiscountCardRepository cardRepository) {
        this.productRepository = productRepository;
        this.cardRepository = cardRepository;
    }

    /**
     * Создаем чек с нужными для нас полями
     * сохраняем в файл
     *
     * @param source Аргументы, передающиеся в виде строки
     * @return Receipt
     */
    public Receipt createReceipt(String source) {
        Converter converter = new Converter(productRepository);
        //товары по отдельности
        String[] args = converter.getArgs(source);
        Director director = new Director(getBuilder(LineCheck.isCardReceipt(args)));
        Receipt receipt = director.buildReceipt(args);
        // запись в файл
        ReceiptWriter writer = new ReceiptWriter();
        writer.save(receipt.toString());
        return receipt;
    }

    /**
     * В зависимости от того используется ли скидочная карта
     * возвращает нужную реализацию чека
     *
     * @param isCard bool
     * @return ReceiptBuilder
     */
    private ReceiptBuilder getBuilder(boolean isCard) {
        return isCard
                ? new ReceiptWithSale(productRepository, cardRepository)
                : new ReceiptWithoutSale(productRepository);
    }
}
