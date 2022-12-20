package edu.clevertec.task.receipt.count;

import edu.clevertec.task.model.DiscountCard;
import edu.clevertec.task.model.Product;
import edu.clevertec.task.receipt.exception.DiscountCardNotFoundException;
import edu.clevertec.task.repository.DiscountCardRepository;
import edu.clevertec.task.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class SalePriceCounterTest {

    private SalePriceCounter salePriceCounter;

    @MockBean
    private FullPriceCounter fullPriceCounter;
    @MockBean
    private DiscountCardRepository cardRepository;
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

        DiscountCard discountCard = new DiscountCard();
        discountCard.setNumber(1111);
        discountCard.setSale(10);

        products = new HashMap<>();
        products.put(product1.getId(), 3);
        products.put(product2.getId(), 4);
        products.put(product3.getId(), 10);

        salePriceCounter = new SalePriceCounter(fullPriceCounter, 1111, cardRepository);
        when(cardRepository.findByNumber(anyInt())).thenReturn(discountCard);
        when(cardRepository.existsByNumber(anyInt())).thenReturn(true);
        //fullCost
        when(fullPriceCounter.getCost(anyMap())).thenReturn(59.0);
    }

    @Test
    void getCost() {
        assertThat(salePriceCounter.getCost(products)).isEqualTo(53.1);
        when(cardRepository.existsByNumber(anyInt())).thenReturn(false);
        Throwable throwable = catchThrowable(() -> {
            salePriceCounter.getCost(products);
        });
        assertThat(throwable).isInstanceOf(DiscountCardNotFoundException.class);
        assertThat(throwable.getMessage()).isNotBlank();
    }
}