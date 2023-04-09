package com.company.gamestore.viewmodel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class InvoiceViewModel {
    @NotNull
    @Size(max = 50)
    private String name;

    @Size(max = 100)
    private String street;

    @NotNull
    @Size(max = 50)
    private String city;

    @NotNull
    @Size(max = 20)
    private  String state;

    @Size(max = 10)
    private String zipcode;

    @NotNull
    @Size(max = 50)
    private String itemType;

    @NotNull
    private int itemId;


    @NotNull
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceViewModel that = (InvoiceViewModel) o;
        return Objects.equals(getItemId(), that.getItemId()) && Objects.equals(getQuantity(), that.getQuantity()) && Objects.equals(getName(), that.getName()) && Objects.equals(getStreet(), that.getStreet()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getState(), that.getState()) && Objects.equals(getZipcode(), that.getZipcode()) && Objects.equals(getItemType(), that.getItemType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getStreet(), getCity(), getState(), getZipcode(), getItemType(), getItemId(), getQuantity());
    }
}
