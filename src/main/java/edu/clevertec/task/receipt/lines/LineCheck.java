package edu.clevertec.task.receipt.lines;

import java.util.regex.Pattern;

public class LineCheck {

    public static boolean isCorrectSource(String source) {
        Pattern pattern = Pattern.compile("(\\d-\\d\\s*)+(card-\\d{4})?");
        return pattern.matcher(source.trim()).matches();
    }

    public static boolean isCardSource(String source) {
        return source.contains("card");
    }
}
