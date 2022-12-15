package edu.clevertec.task.receipt.converter;

import edu.clevertec.task.receipt.exception.IncorrectInputSourceException;
import edu.clevertec.task.receipt.lines.LineCheck;
import edu.clevertec.task.receipt.lines.LineParsing;

import java.util.HashMap;
import java.util.Map;

public class Converter {

    public Map<Long, Integer> getProducts(String source) {
        if (LineCheck.isCorrectSource(source)) {
            Map<Long, Integer> products = new HashMap<>();
            //разделяем по пробелу
            String[] elements = LineParsing.parse(source);
            for (String element : elements) {
                if (!LineCheck.isCardSource(element)) { //откидываем элемент с дисконтной картой
                    products.put(
                            Long.valueOf(LineParsing.getLeftPart(element)),
                            Integer.valueOf(LineParsing.getRightPart(element))
                    );
                }
            }
            return products;
        } else {
            throw new IncorrectInputSourceException("Incorrect source\n" + source
                    + "\nsource will be match regular expression:\n(\\d-\\d\\s*)+(card-\\d{4})?"  );
        }
    }

    public Integer getDiscountCard(String source) {
        if (LineCheck.isCorrectSource(source)) {
            String[] elements = LineParsing.parse(source);
            for (String element : elements) {
                if (LineCheck.isCardSource(element)) { //находим элемент с дисконтной картой
                    return Integer.valueOf(element);
                }
            }
            return null;
        } else {
            throw new IncorrectInputSourceException("Incorrect source\n" + source
                    + "\nsource will be match regular expression:\n(\\d-\\d\\s*)+(card-\\d{4})?"  );
        }
    }



}
