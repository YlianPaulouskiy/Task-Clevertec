package edu.clevertec.task.receipt;

import edu.clevertec.task.model.Receipt;
import edu.clevertec.task.receipt.builder.Director;
import edu.clevertec.task.receipt.builder.ReceiptBuilder;
import edu.clevertec.task.receipt.builder.ReceiptWithSale;
import edu.clevertec.task.receipt.builder.ReceiptWithoutSale;
import edu.clevertec.task.receipt.lines.LineCheck;

public class ReceiptConstructor {

    private void start(String[] args) {
        Director director = new Director(getBuilder(isCard(args)));
        Receipt receipt = director.buildReceipt(args);
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
                ? new ReceiptWithSale()
                : new ReceiptWithoutSale();
    }

}
