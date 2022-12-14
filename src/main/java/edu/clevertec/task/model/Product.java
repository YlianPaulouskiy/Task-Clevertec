package edu.clevertec.task.model;

import edu.clevertec.task.model.parent.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import lombok.Getter;
//import lombok.Setter;

@Entity
//@Getter
//@Setter
public class Product extends BaseModel {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
