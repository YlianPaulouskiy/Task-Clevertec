package edu.clevertec.task.model;

import edu.clevertec.task.model.parent.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import lombok.Getter;
//import lombok.Setter;

@Entity
//@Getter
//@Setter
public class DiscountCard extends BaseModel {

    @Column(nullable = false, unique = true)
    private Integer number;

    @Column(nullable = false)
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
