package edu.clevertec.task.receipt.writer;

import java.io.FileWriter;
import java.io.IOException;

public class ReceiptWriter {

    public void save(String source) {
        try (FileWriter fileWriter = new FileWriter("receipt.txt")) {
            fileWriter.write(source);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
