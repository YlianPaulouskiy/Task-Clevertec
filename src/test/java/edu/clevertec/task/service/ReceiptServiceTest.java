package edu.clevertec.task.service;

import edu.clevertec.task.model.DiscountCard;
import edu.clevertec.task.model.Product;
import edu.clevertec.task.model.Receipt;
import edu.clevertec.task.receipt.converter.Converter;
import edu.clevertec.task.repository.DiscountCardRepository;
import edu.clevertec.task.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class ReceiptServiceTest {

    @Autowired
    private ReceiptService receiptService;
    @MockBean
    private ProductRepository productRepository;
    @MockBean
    private DiscountCardRepository cardRepository;
    @MockBean
    private Converter converter;

    private Receipt receiptWithoutSale;
    private Receipt receiptWithSale;

    @BeforeEach
    void setUp() {
        String sourceWithoutSale = "1-4 5-2 3-6";
        String[] argsWithoutSale = {"1-4", "5-2", "3-6"};

        String sourceWithSale = "1-4 5-2 3-6 card-1111";
        String[] argsWithSale = {"1-4", "5-2", "3-6", "card-1111"};

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

        when(productRepository.existsById(anyLong())).thenReturn(true);
        when(productRepository.getReferenceById(anyLong())).thenReturn(product1, product2, product3);
        when(cardRepository.existsByNumber(anyInt())).thenReturn(true);
        when(cardRepository.findByNumber(anyInt())).thenReturn(discountCard);
        when(converter.getArgs(sourceWithoutSale)).thenReturn(argsWithoutSale);
        when(converter.getArgs(sourceWithSale)).thenReturn(argsWithSale);

        receiptWithoutSale = receiptService.createReceipt(sourceWithoutSale);
        receiptWithSale = receiptService.createReceipt(sourceWithSale);
    }

    @Test
    void createReceipt() {
        assertThat(receiptWithoutSale).isNotNull();
        assertThat(receiptWithoutSale.getProducts().isEmpty()).isEqualTo(false);
        assertThat(receiptWithoutSale.getSale()).isEqualTo(null);
        assertThat(receiptWithoutSale.getTotalWithSale()).isEqualTo(null);

        assertThat(receiptWithSale).isNotNull();
        assertThat(receiptWithSale.getProducts().isEmpty()).isEqualTo(false);
        assertThat(receiptWithSale.getSale()).isNotNull();
        assertThat(receiptWithSale.getTotalWithSale()).isNotNull();
    }
}