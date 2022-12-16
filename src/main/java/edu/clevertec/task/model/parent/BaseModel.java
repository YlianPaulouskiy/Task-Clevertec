package edu.clevertec.task.model.parent;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 * Общий класс для моделей бд, содержащий Id
 */
@MappedSuperclass
public abstract class BaseModel {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
