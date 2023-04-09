package com.company.gamestore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "fee")
public class Fee implements Serializable {
    @Id
    @Column(name = "fee_id")
    private int id;

    @NotNull
    @Digits(integer =8, fraction =2)
    private BigDecimal fee;

    @Size(max = 50)
    @NotNull
    @Column(name = "product_type")
    private String product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fee fee1 = (Fee) o;
        return getId() == fee1.getId() && Objects.equals(getFee(), fee1.getFee()) && Objects.equals(getProduct(), fee1.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFee(), getProduct());
    }

    @Override
    public String toString() {
        return "Fee{" +
                "id=" + id +
                ", fee=" + fee +
                ", product='" + product + '\'' +
                '}';
    }
}
