package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // method to calculate the balance of the customer
    public int getBalance() {
        int balance = 0;

        for (AccountRecord charge : charges){
            balance += charge.getCharge();
        }

        return balance;
    }

    public List<AccountRecord> getCharges() {
        return new ArrayList<>(charges);
    }

    // setter method to add an AccountRecord charge to the charges list
    public void addCharge(AccountRecord charge){
        charges.add(charge);
    }

    @Override
    public String toString() {
        return "Customer ID: " + id + ", Name: " + name + ", Customer Balance: " + getBalance();
    }
}
