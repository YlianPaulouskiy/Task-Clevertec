package edu.clevertec.task.model;

import edu.clevertec.task.model.parent.BaseModel;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * Модель продукта
 */
@Entity
@Getter
@Setter
public class Product extends BaseModel {

    private String name;
    private Double price;

}

