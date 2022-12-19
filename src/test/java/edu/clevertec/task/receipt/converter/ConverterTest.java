package edu.clevertec.task.receipt.converter;

import edu.clevertec.task.model.Product;
import edu.clevertec.task.receipt.exception.IncorrectInputSourceException;
import edu.clevertec.task.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class ConverterTest {

    @Autowired
    private Converter converter;
    @MockBean
    private ProductRepository productRepository;

    private String sourceWithCard;
    private String sourceWithoutCard;
    private String exceptionSource;
    private String[] args;
    private Product product;



    @BeforeEach
    void setUp() {
        sourceWithCard = "4-1 5-2 3-6 card-1111";
        sourceWithoutCard = "4-1 5-2 3-6";
        args = new String[] {"4-1", "5-2", "3-6", "card-1111"};
        exceptionSource = "";
        product = new Product();
    }

    @Test
    void getProductIds() {
        assertThat(converter.getProductIds(args).isEmpty()).isEqualTo(false);
        assertThat(converter.getProductIds(args).size()).isEqualTo(3);
        assertThat(converter.getProductIds(args).get(4L)).isEqualTo(1);
        assertThat(converter.getProductIds(args).get(5L)).isEqualTo(2);
        assertThat(converter.getProductIds(args).get(3L)).isEqualTo(6);
    }

    @Test
    void getDiscountCard() {
        assertThat(converter.getDiscountCard(args)).isEqualTo(1111);
        assertThat(converter.getDiscountCard(converter.getArgs(sourceWithoutCard))).isEqualTo(null);
    }

    @Test
    void getProducts() {
        when(productRepository.existsById(anyLong())).thenReturn(true);
        when(productRepository.getReferenceById(anyLong())).thenReturn(product);
        assertThat(converter.getProducts(args).size()).isNotEqualTo(0);
    }

    @Test
    void getArgs() {
        assertThat(converter.getArgs(sourceWithCard)).isEqualTo(args);
        //проверка исключения
        Throwable throwable = catchThrowable(() -> {
            converter.getArgs(exceptionSource);
        });
        assertThat(throwable).isInstanceOf(IncorrectInputSourceException.class);
        assertThat(throwable.getMessage()).isNotBlank();
    }
}