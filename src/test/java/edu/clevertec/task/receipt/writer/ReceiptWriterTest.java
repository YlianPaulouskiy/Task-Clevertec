package edu.clevertec.task.receipt.writer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ReceiptWriterTest {

    @Autowired
    private ReceiptWriter receiptWriter;

    @BeforeEach
    void setUp() {
        try (FileWriter writer = new FileWriter(ReceiptWriter.SAVE_PATH)) {
            writer.write("");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
        try (FileWriter writer = new FileWriter(ReceiptWriter.SAVE_PATH)) {
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void save() {
        try(BufferedReader reader = new BufferedReader(new FileReader(ReceiptWriter.SAVE_PATH))) {
            String source = "SOMETHING TEXT";
            //пуст ли файл
            assertThat(reader.read()).isEqualTo(-1);
            receiptWriter.save(source);
            //не пуст после записи
            assertThat(reader.readLine()).isEqualTo(source);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}