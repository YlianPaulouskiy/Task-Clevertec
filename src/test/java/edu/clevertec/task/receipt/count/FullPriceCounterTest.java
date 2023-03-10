package edu.clevertec.task.receipt.count;

import edu.clevertec.task.model.Product;
import edu.clevertec.task.receipt.exception.ProductNotFoundException;
import edu.clevertec.task.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class FullPriceCounterTest {

    @Autowired
    private FullPriceCounter fullPriceCounter;
    @MockBean
    private ProductRepository productRepository;

    private Map<Long, Integer> products;

    @BeforeEach
    void setUp() {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setPrice(10.0);
        Product product2 = new Product();
        product2.setId(2L);
        product2.setPrice(5.0);
        Product product3 = new Product();
        product3.setId(3L);
        product3.setPrice(1.0);

        products = new HashMap<>();
        products.put(product1.getId(), 3);
        products.put(product2.getId(), 4);
        products.put(product3.getId(), 10);

        when(productRepository.existsById(anyLong())).thenReturn(true);
        when(productRepository.getReferenceById(anyLong())).thenReturn(product1, product2, product3);
    }

    @Test
    void getCost() {
        assertThat(fullPriceCounter.getCost(products)).isEqualTo(59.0);
        when(productRepository.existsById(anyLong())).thenReturn(false);
        Throwable throwable = catchThrowable(() -> {
            fullPriceCounter.getCost(products);
        });
        assertThat(throwable).isInstanceOf(ProductNotFoundException.class);
        assertThat(throwable.getMessage()).isNotBlank();
    }
}