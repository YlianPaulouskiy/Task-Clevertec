package edu.clevertec.task;

import edu.clevertec.task.receipt.ReceiptConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskApp {

    public static void main(String[] args) {
        ReceiptConstructor constructor = new ReceiptConstructor(SpringApplication.run(TaskApp.class, args));
        constructor.start(args);
    }

}
