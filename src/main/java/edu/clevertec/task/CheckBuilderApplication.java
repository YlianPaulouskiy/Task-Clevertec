package edu.clevertec.task;

import edu.clevertec.task.receipt.builder.Director;
import edu.clevertec.task.receipt.builder.ReceiptWithSale;
import edu.clevertec.task.receipt.builder.ReceiptWithoutSale;
import edu.clevertec.task.receipt.lines.LineCheck;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CheckBuilderApplication {

    public static void main(String[] args) {
//        SpringApplication.run(CheckBuilderApplication.class, args);
        boolean useCard = false;

        for (String arg : args) {
            if (LineCheck.isCardSource(arg)) {
                useCard = true;
            }
        }

        if (useCard) {
            new ReceiptWithSale();
        } else {
            new ReceiptWithoutSale();
        }

        Director director = new Director()
    }

}
