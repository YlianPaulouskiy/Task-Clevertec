package edu.clevertec.task.receipt.writer;

import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс для записи в файл
 */
@Component
public class ReceiptWriter {

    /**
     * Путь, куда сохраняется чек
     */
    public static final String SAVE_PATH = "D:\\java\\my projects\\taskClevertec\\build\\resources\\main\\receipt.txt";

    /**
     * Сохраняет переданную строку в файл
     *
     * @param source Строка, которую нужно сохранить
     */
    public void save(String source) {
        try (FileWriter fileWriter = new FileWriter(SAVE_PATH)) {
            fileWriter.write(source);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
