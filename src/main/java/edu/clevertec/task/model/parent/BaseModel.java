package edu.clevertec.task.model.parent;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * Общий класс для моделей бд, содержащий Id
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BaseModel {

    @Id
    private Long id;

}
