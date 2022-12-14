package edu.clevertec.task;

import edu.clevertec.task.receipt.lines.LineCheck;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CheckBuilderApplication {

    public static void main(String[] args) {
//        SpringApplication.run(CheckBuilderApplication.class, args);
        System.out.println(LineCheck.isCorrectSource("3-4 card-1234"));
    }

}
