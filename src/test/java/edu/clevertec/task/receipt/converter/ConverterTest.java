package edu.clevertec.task.receipt.converter;

import edu.clevertec.task.model.Product;
import edu.clevertec.task.receipt.exception.IncorrectInputSourceException;
import edu.clevertec.task.receipt.exception.ProductNotFoundException;
import edu.clevertec.task.receipt.lines.LineCheck;
import edu.clevertec.task.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
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

    @BeforeEach
    void setUp() {
        sourceWithCard = "4-1 5-2 3-6 card-1111";
        sourceWithoutCard = "4-1 5-2 3-6";
        exceptionSource = "";
        args = new String[] {"4-1", "5-2", "3-6", "card-1111"};

        Product product1 = new Product();
        product1.setId(1L);
        product1.setPrice(10.0);
        Product product2 = new Product();
        product2.setId(2L);
        product2.setPrice(5.0);
        Product product3 = new Product();
        product3.setId(3L);
        product3.setPrice(1.0);

        when(productRepository.existsById(anyLong())).thenReturn(true);
        when(productRepository.getReferenceById(anyLong())).thenReturn(product1, product2, product3);
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
        assertThat(converter.getProducts(args).size()).isEqualTo(3);
        //проверка исключения
        when(productRepository.existsById(anyLong())).thenReturn(false);
        Throwable throwable = catchThrowable(() -> {
            converter.getProducts(args);
        });
        assertThat(throwable).isInstanceOf(ProductNotFoundException.class);
        assertThat(throwable.getMessage()).isNotBlank();
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