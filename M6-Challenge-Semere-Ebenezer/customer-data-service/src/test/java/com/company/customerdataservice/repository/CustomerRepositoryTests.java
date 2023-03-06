package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTests {
    @Autowired
    CustomerRepository repo;

    @Before
    public void setUp() throws Exception {
        repo.deleteAll();
    }

    @Test
    public void shouldCreateCustomer(){
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("Ebenezer");
        customer.setLastName("Scrooge");
        customer.setEmail("escrooge@gmail.com");
        customer.setCompany("Scrooge and Sons");
        customer.setPhone("555-555-5555");
        customer.setAddress1("123 Main St");
        customer.setAddress2("456 Second St");
        customer.setCity("Springfield");
        customer.setState("IL");
        customer.setPostalCode("12345");
        customer.setCountry("USA");

        // Act
        repo.save(customer);

        // Assert
        Optional<Customer> customer1 = repo.findById(customer.getId());
        assertEquals(customer1.get(), customer);
    }

    @Test
    public void shouldUpdateCustomer() {
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("Ebenezer");
        customer.setLastName("Scrooge");
        customer.setEmail("escrooge@gmail.com");
        customer.setCompany("Scrooge and Sons");
        customer.setPhone("555-555-5555");
        customer.setAddress1("123 Main St");
        customer.setAddress2("456 Second St");
        customer.setCity("Springfield");
        customer.setState("IL");
        customer.setPostalCode("12345");
        customer.setCountry("USA");

        repo.save(customer);

        // Act
        customer.setFirstName("Abenezer");
        repo.save(customer);

        // Assert
        Optional<Customer> customer1 = repo.findById(customer.getId());
        assertEquals(customer1.get(), customer);
    }

    @Test
    public void shouldDeleteCustomer() {
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("Ebenezer");
        customer.setLastName("Scrooge");
        customer.setEmail("escrooge@gmail.com");
        customer.setCompany("Scrooge and Sons");
        customer.setPhone("555-555-5555");
        customer.setAddress1("123 Main St");
        customer.setAddress2("456 Second St");
        customer.setCity("Springfield");
        customer.setState("IL");
        customer.setPostalCode("12345");
        customer.setCountry("USA");

        repo.save(customer);

        // Act
        repo.deleteById(customer.getId());

        // Assert
        Optional<Customer> customer1 = repo.findById(customer.getId());
        assertFalse(customer1.isPresent());
    }

    @Test
    public void shouldGetCustomerById() {
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("Ebenezer");
        customer.setLastName("Scrooge");
        customer.setEmail("escrooge@gmail.com");
        customer.setCompany("Scrooge and Sons");
        customer.setPhone("555-555-5555");
        customer.setAddress1("123 Main St");
        customer.setAddress2("456 Second St");
        customer.setCity("Springfield");
        customer.setState("IL");
        customer.setPostalCode("12345");
        customer.setCountry("USA");

        repo.save(customer);

        // Act
        repo.findById(customer.getId());

        // Assert
        Optional<Customer> customer1 = repo.findById(customer.getId());
        assertEquals(customer1.get(), customer);
    }

    @Test
    public void shouldGetCustomerByState() {
        // Arrange
        Customer customer1 = new Customer();
        customer1.setFirstName("Ebenezer");
        customer1.setLastName("Scrooge");
        customer1.setEmail("escrooge@gmail.com");
        customer1.setCompany("Scrooge and Sons");
        customer1.setPhone("555-555-5555");
        customer1.setAddress1("123 Main St");
        customer1.setAddress2("456 Second St");
        customer1.setCity("Springfield");
        customer1.setState("IL");
        customer1.setPostalCode("12345");
        customer1.setCountry("USA");

        repo.save(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstName("Michael");
        customer2.setLastName("Redoth");
        customer2.setEmail("mredoth@gmail.com");
        customer2.setCompany("Redoth and Sons");
        customer2.setPhone("111-111-1111");
        customer2.setAddress1("012 Main St");
        customer2.setAddress2("345 Second St");
        customer2.setCity("Chicago");
        customer2.setState("IL");
        customer2.setPostalCode("54321");
        customer2.setCountry("USA");

        repo.save(customer2);

        // Assert
        assertEquals(2, repo.findByState("IL").size());
    }
}
