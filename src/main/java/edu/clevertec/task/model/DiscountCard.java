package edu.clevertec.task.model;

import edu.clevertec.task.model.parent.BaseModel;
import jakarta.persistence.Entity;

@Entity
public class DiscountCard extends BaseModel {

    private Integer number;
    private Integer sale;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }
}
