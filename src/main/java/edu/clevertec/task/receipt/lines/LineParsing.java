package edu.clevertec.task.receipt.lines;

public class LineParsing {

    public static String getLeftPart(String source) {
        return source.split("-")[0];
    }

    public  static  String getRightPart(String source) {
        return source.split("-")[1];
    }

}
