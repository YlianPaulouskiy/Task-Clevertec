package edu.clevertec.task.receipt.count;

import edu.clevertec.task.receipt.exception.DiscountCardNotFoundException;
import edu.clevertec.task.repository.DiscountCardRepository;
import lombok.AllArgsConstructor;;

import java.util.Map;

/**
 * Класс для подсчета стоимости с учетом скидочной карты
 */
public class SalePriceCounter extends CounterDecorator {

    private final Integer cardNumber;
    private final DiscountCardRepository discountCardRepository;

    public SalePriceCounter(Counter counter, Integer cardNumber, DiscountCardRepository discountCardRepository) {
        super(counter);
        this.cardNumber = cardNumber;
        this.discountCardRepository = discountCardRepository;
    }

    @Override
    public Double getCost(Map<Long, Integer> products) {
        if (discountCardRepository.existsByNumber(cardNumber)) {
            double sale = discountCardRepository.findByNumber(cardNumber).getSale();
            //скидочная стоимость = полная - полная*скидку
            return super.getCost(products) - super.getCost(products) * sale / 100;
        } else {
            throw new DiscountCardNotFoundException("Discount card " + cardNumber + " not founded.");
        }
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

}
