package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CustomerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository repo;
    private ObjectMapper mapper = new ObjectMapper();

    // Tests POST route that creates a new customer.
    @Test
    public void shouldCreateCustomer() throws Exception {
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

        String inputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(
                post("/customers")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print()).andExpect(status().isCreated());
    }

    // Tests PUT route that updates an existing customer.
    @Test
    public void shouldUpdateCustomer() throws Exception {
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

        String inputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(put("/customers")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print()).andExpect(status().isNoContent());
    }

    // Tests DELETE route that deletes an existing customer.
    @Test
    public void shouldDeleteCustomerById() throws Exception {
        mockMvc.perform(delete("/customers/1")
        ).andDo(print()).andExpect(status().isNoContent());
    }

    // Tests GET route that returns a specific customer by id.
    @Test
    public void shouldGetCustomerById() throws Exception {
        mockMvc.perform(get("/customers/1").accept(MediaType.APPLICATION_JSON)
        ).andDo(print()).andExpect(status().isOk());
    }

    // Tests GET route that returns all customers for a specific state.
    @Test
    public void shouldGetCustomersByState() throws Exception {
        mockMvc.perform(get("/customers/state/IL").accept(MediaType.APPLICATION_JSON)
        ).andDo(print()).andExpect(status().isOk());
    }
}
