package edu.clevertec.task.receipt.lines;

import java.util.regex.Pattern;

/**
 * Класс для проверки строк
 */
public class LineCheck {

    /**
     * Проверяет соответствует ли данная строка шаблону
     *
     * @param source строка товаров и дисконтной карты
     * @return bool
     */
    public static boolean isCorrectSource(String source) {
        Pattern pattern = Pattern.compile("(\\d+-\\d+\\s*)+(card-\\d{4})?");
        return pattern.matcher(source.trim()).matches();
    }

    /**
     * Проверяет является ли данная строка картой
     *
     * @param source строка(товар-количество или карта-номер)
     * @return boolean
     */
    public static boolean isCardSource(String source) {
        return source.contains("card");
    }

    /**
     * Проверяет предъявлен ли была скидочная карта
     *
     * @param args товары и скидочная карта
     * @return bool
     */
    public static boolean isCardReceipt(String[] args) {
        boolean isCard = false;
        for (String arg : args) {
            if (LineCheck.isCardSource(arg)) {
                isCard = true;
                break;
            }
        }
        return isCard;
    }

}
