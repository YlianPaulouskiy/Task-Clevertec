package edu.clevertec.task.receipt.lines;

public class LineCheck {

    public static boolean isCardSource(String source) {
        return source.contains("card");
    }

}
