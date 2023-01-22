package com.company;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void shouldCalculateBalance(){

        // Regular Case
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Java Lover");

        AccountRecord accountRecord1 = new AccountRecord();
        accountRecord1.setCharge(50);
        accountRecord1.setChargeDate("12-01-2021");

        AccountRecord accountRecord2 = new AccountRecord();
        accountRecord2.setCharge(500);
        accountRecord2.setChargeDate("01-10-2022");

        AccountRecord accountRecord3 = new AccountRecord();
        accountRecord3.setCharge(5000);
        accountRecord3.setChargeDate("12-22-2021");

        AccountRecord accountRecord4 = new AccountRecord();
        accountRecord4.setCharge(50000);
        accountRecord4.setChargeDate("12-09-2021");

        AccountRecord accountRecord5 = new AccountRecord();
        accountRecord5.setCharge(-5);
        accountRecord5.setChargeDate("01-17-2022");

        customer.addCharge(accountRecord1);
        customer.addCharge(accountRecord2);
        customer.addCharge(accountRecord3);
        customer.addCharge(accountRecord4);
        customer.addCharge(accountRecord5);

        assertEquals(55545, customer.getBalance());

        // Edge Case
        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("Java Hater");

        AccountRecord accountRecord6 = new AccountRecord();
        accountRecord6.setCharge(-0);
        accountRecord6.setChargeDate("12-01-2021");

        AccountRecord accountRecord7 = new AccountRecord();
        accountRecord7.setCharge(50);
        accountRecord7.setChargeDate("01-10-2022");

        AccountRecord accountRecord8 = new AccountRecord();
        accountRecord8.setCharge(-1000);
        accountRecord8.setChargeDate("12-22-2021");

        customer2.addCharge(accountRecord6);
        customer2.addCharge(accountRecord7);
        customer2.addCharge(accountRecord8);

        assertEquals(-950, customer2.getBalance());
    }

    @Test
    public void shouldPrintCustomerDetails(){

        // Regular Case
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Java Lover");

        AccountRecord accountRecord1 = new AccountRecord();
        accountRecord1.setCharge(500);
        accountRecord1.setChargeDate("12-01-2021");

        AccountRecord accountRecord2 = new AccountRecord();
        accountRecord2.setCharge(500);
        accountRecord2.setChargeDate("01-10-2022");

        AccountRecord accountRecord3 = new AccountRecord();
        accountRecord3.setCharge(-1000);
        accountRecord3.setChargeDate("12-22-2021");

        AccountRecord accountRecord4 = new AccountRecord();
        accountRecord4.setCharge(-100);
        accountRecord4.setChargeDate("12-09-2021");

        AccountRecord accountRecord5 = new AccountRecord();
        accountRecord5.setCharge(100);
        accountRecord5.setChargeDate("01-17-2022");

        customer.addCharge(accountRecord1);
        customer.addCharge(accountRecord2);
        customer.addCharge(accountRecord3);
        customer.addCharge(accountRecord4);
        customer.addCharge(accountRecord5);

        String expected = "Customer ID: 1, Name: Java Lover, Customer Balance: 0";

        assertEquals(expected, customer.toString());

        // Edge Case
        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("");

        AccountRecord accountRecord6 = new AccountRecord();
        accountRecord6.setCharge(0);
        accountRecord6.setChargeDate("12-01-2021");

        AccountRecord accountRecord7 = new AccountRecord();
        accountRecord7.setCharge(-100000);
        accountRecord7.setChargeDate("01-10-2022");

        AccountRecord accountRecord8 = new AccountRecord();
        accountRecord8.setCharge(100000);
        accountRecord8.setChargeDate("12-22-2021");

        customer2.addCharge(accountRecord6);
        customer2.addCharge(accountRecord7);
        customer2.addCharge(accountRecord8);

        String expected2 = "Customer ID: 2, Name: , Customer Balance: 0";

        assertEquals(expected2, customer2.toString());

    }
}
