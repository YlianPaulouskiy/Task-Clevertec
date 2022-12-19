package edu.clevertec.task.receipt.lines;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LineParsingTest {

    @Test
    void parse() {
        String source1 = "4-1 3-2 5-2 11-2 card-1111";
        assertThat(LineParsing.parse(source1).length).isEqualTo(5);
        assertThat(LineParsing.parse(source1)[0]).isEqualTo("4-1");
        assertThat(LineParsing.parse(source1)[1]).isEqualTo("3-2");
        assertThat(LineParsing.parse(source1)[2]).isEqualTo("5-2");
        assertThat(LineParsing.parse(source1)[3]).isEqualTo("11-2");
        assertThat(LineParsing.parse(source1)[4]).isEqualTo("card-1111");
    }

    @Test
    void getLeftPart() {
        assertThat(LineParsing.getLeftPart("4-1")).isEqualTo("4");
        assertThat(LineParsing.getLeftPart("card-1234")).isEqualTo("card");
    }

    @Test
    void getRightPart() {
        assertThat(LineParsing.getRightPart("4-1")).isEqualTo("1");
        assertThat(LineParsing.getRightPart("card-1234")).isEqualTo("1234");
    }
}