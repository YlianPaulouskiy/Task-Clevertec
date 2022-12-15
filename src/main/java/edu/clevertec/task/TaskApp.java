package edu.clevertec.task;

import edu.clevertec.task.receipt.ReceiptConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskApp {

    public static void main(String[] args) {
//        SpringApplication.run(CheckBuilderApplication.class, args);
        ReceiptConstructor constructor = new ReceiptConstructor();
        constructor.start(args);
    }

}
