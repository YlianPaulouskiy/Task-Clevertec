package edu.clevertec.task.repository;

import edu.clevertec.task.model.DiscountCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountCardRepository extends JpaRepository<DiscountCard, Long> {

    DiscountCard findByNumber(Integer number);

    boolean existsByNumber(Integer number);

}
