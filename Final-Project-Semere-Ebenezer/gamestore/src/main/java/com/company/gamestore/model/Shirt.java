package com.company.gamestore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "shirt_id")
public class Shirt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer shirtId;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    private Double price;

    private String size;

    private String color;

    private Integer shirtQuantity;

    public Integer getShirtId() {
        return shirtId;
    }

    public void setShirtId(Integer shirtId) {
        this.shirtId = shirtId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getShirtQuantity() {
        return shirtQuantity;
    }

    public void setShirtQuantity(Integer shirtQuantity) {
        this.shirtQuantity = shirtQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shirt shirt = (Shirt) o;
        return Objects.equals(shirtId, shirt.shirtId) && Objects.equals(size, shirt.size) && Objects.equals(color, shirt.color) && Objects.equals(shirtQuantity, shirt.shirtQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shirtId, size, color, shirtQuantity);
    }
}
