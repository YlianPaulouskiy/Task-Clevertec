package edu.clevertec.task.receipt.writer;

import java.io.FileWriter;
import java.io.IOException;


/**
 * Класс для записи в файл
 */
public class ReceiptWriter {

    /**
     * Сохраняет переданную строку в файл
     *
     * @param source Строка, которую нужно сохранить
     */
    public void save(String source) {
        try (FileWriter fileWriter = new FileWriter(
                // путь куда сохраняется чек
                "D:\\java\\my projects\\taskClevertec\\build\\resources\\main\\receipt.txt")) {
            fileWriter.write(source);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
