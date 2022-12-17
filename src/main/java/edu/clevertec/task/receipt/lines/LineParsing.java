package edu.clevertec.task.receipt.lines;

/**
 * Класс для разделения строки
 */
public class LineParsing {

    /**
     * Разбивает строку по пробелам
     *
     * @param source строка товаров и дисконтной карты
     * @return массив строк
     */
    public static String[] parse(String source) {
        return source.split("\\s");
    }

    /**
     * Получает левую часть относительно символа '-'
     *
     * @param source строка(товар-количество или карта-номер)
     * @return строковое представление левой части
     */
    public static String getLeftPart(String source) {
        return source.split("-")[0];
    }

    /**
     * Получает правую часть относительно символа '-'
     *
     * @param source строка(товар-количество или карта-номер)
     * @return строковое представление правой части
     */
    public static String getRightPart(String source) {
        return source.split("-")[1];
    }

}
