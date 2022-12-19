package edu.clevertec.task.receipt.lines;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LineCheckTest {

    @Test
    void isCorrectSource() {
        assertThat(LineCheck.isCorrectSource("4-1 3-2 card-1111")).isEqualTo(true);
        assertThat(LineCheck.isCorrectSource("10-10 3-5 card-1234")).isEqualTo(true);
        assertThat(LineCheck.isCorrectSource("-1")).isEqualTo(false);
        assertThat(LineCheck.isCorrectSource("card-1234")).isEqualTo(false);
        assertThat(LineCheck.isCorrectSource("")).isEqualTo(false);
        assertThat(LineCheck.isCorrectSource("card-1234 4-1 5-2")).isEqualTo(false);
        assertThat(LineCheck.isCorrectSource("4-2 card-12345")).isEqualTo(false);
    }

    @Test
    void isCardSource() {
        assertThat(LineCheck.isCardSource("card-1234")).isEqualTo(true);
        assertThat(LineCheck.isCardSource("")).isEqualTo(false);
        assertThat(LineCheck.isCardSource("1234")).isEqualTo(false);
    }

    @Test
    void isCardReceipt() {
        assertThat(LineCheck.isCardReceipt(new String[] {"4-2", "2-5", "card-1234"})).isEqualTo(true);
        assertThat(LineCheck.isCardReceipt(new String[] {"4-2", "2-5", "car1234"})).isEqualTo(false);
        assertThat(LineCheck.isCardReceipt(new String[] {"4-2", "2-5", ""})).isEqualTo(false);
        assertThat(LineCheck.isCardReceipt(new String[] {})).isEqualTo(false);
    }
}