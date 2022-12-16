package edu.clevertec.task.receipt;

import edu.clevertec.task.model.Receipt;
import edu.clevertec.task.receipt.builder.Director;
import edu.clevertec.task.receipt.builder.ReceiptBuilder;
import edu.clevertec.task.receipt.builder.ReceiptWithSale;
import edu.clevertec.task.receipt.builder.ReceiptWithoutSale;
import edu.clevertec.task.receipt.lines.LineCheck;
import edu.clevertec.task.receipt.writer.ReceiptWriter;
import edu.clevertec.task.repository.DiscountCardRepository;
import edu.clevertec.task.repository.ProductRepository;
import org.springframework.context.ConfigurableApplicationContext;

public class ReceiptConstructor {

    private final ConfigurableApplicationContext context;

    public ReceiptConstructor(ConfigurableApplicationContext context) {
        this.context = context;
    }

    public void start(String[] args) {
        Director director = new Director(getBuilder(isCard(args)));
        Receipt receipt = director.buildReceipt(args);
        // запись в файл
        ReceiptWriter writer = new ReceiptWriter();
        writer.save(receipt.toString());
        //вывод в консоль
        System.out.println(receipt);
    }

    private boolean isCard(String[] args) {
        boolean isCard = false;
        for (String arg : args) {
            if (LineCheck.isCardSource(arg)) {
                isCard = true;
                break;
            }
        }
        return isCard;
    }

    private ReceiptBuilder getBuilder(boolean isCard) {
        return isCard
                ? new ReceiptWithSale(context.getBean(ProductRepository.class), context.getBean(DiscountCardRepository.class))
                : new ReceiptWithoutSale(context.getBean(ProductRepository.class));
    }

}
