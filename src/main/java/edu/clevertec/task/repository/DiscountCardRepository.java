package edu.clevertec.task.repository;

import edu.clevertec.task.model.DiscountCard;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс для выполнения запросов к таблице discount_card
 */
public interface DiscountCardRepository extends JpaRepository<DiscountCard, Long> {

    /**
     * Возвращает карту по ее номеру
     *
     * @param number номер карты
     * @return DiscountCard
     */
    DiscountCard findByNumber(Integer number);

    /**
     * Проверяет по номеру карты есть ли она в базе
     *
     * @param number номер карты
     * @return boolean
     */
    boolean existsByNumber(Integer number);

}
