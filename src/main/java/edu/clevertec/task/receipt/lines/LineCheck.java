package edu.clevertec.task.receipt.lines;

/**
 * Класс для проверки строк
 */
public class LineCheck {

    /**
     * Проверяет является ли данная строка картой
     *
     * @param source строка(товар-количество или карта-номер)
     * @return boolean
     */
    public static boolean isCardSource(String source) {
        return source.contains("card");
    }

}
