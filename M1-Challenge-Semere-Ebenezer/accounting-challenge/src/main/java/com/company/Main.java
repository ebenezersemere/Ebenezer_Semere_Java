package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {

        // Create a map of {ID : Customer} pairs
        HashMap<Integer, Customer> customerMap = new HashMap<>();

        // Iterate through the customer data
        for (String[] data : customerData){
            int customerId = Integer.parseInt(data[0]);

            // Create a new account record
            AccountRecord account = new AccountRecord();
            account.setCharge(Integer.parseInt(data[2]));
            account.setChargeDate(data[3]);

            // If the customer is not in the map, add them
            if (!customerMap.containsKey(customerId)){
                Customer customer = new Customer();
                customer.setName(data[1]);
                customer.setId(customerId);

                customerMap.put(customerId, customer);
            }

            // Add the charge to the customer's account
            customerMap.get(customerId).addCharge(account);
        }

        // Print the customers with positive and negative balances
        System.out.println("Positive accounts:");
        customerMap.values().stream().filter(customer -> customer.getBalance() >= 0).forEach(System.out::println);

        System.out.println("Negative accounts:");
        customerMap.values().stream().filter(customer -> customer.getBalance() < 0).forEach(System.out::println);
    }
}
