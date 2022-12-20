package edu.clevertec.task.model;

import edu.clevertec.task.model.parent.BaseModel;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * Модель скидочной карты
 */
@Entity
@Getter
@Setter
public class DiscountCard extends BaseModel {

    private Integer number;
    private Integer sale;

}
