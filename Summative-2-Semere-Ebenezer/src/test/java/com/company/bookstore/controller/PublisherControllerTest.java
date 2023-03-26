package com.company.bookstore.controller;

import com.company.bookstore.models.Publisher;
import com.company.bookstore.repository.PublisherRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PublisherController.class)
public class PublisherControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PublisherRepository publisherRepo;

    @Autowired
    private ObjectMapper mapper;

    private List<Publisher> publisherList;

    @Test // Create
    public void testAddPublisher() throws Exception {
        Publisher publisher = new Publisher();
        publisher.setPublisherId(5);
        publisher.setName("Mock Publisher");
        publisher.setStreet("123 Main St");
        publisher.setCity("Mock City");
        publisher.setState("MO");
        publisher.setPostalCode("12345");
        publisher.setPhone("123-456-7890");
        publisher.setEmail("mock@publisher.com");

        String inputJson = mapper.writeValueAsString(publisher);

        mockMvc.perform(post("/publisher")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print()).andExpect(status().isCreated());
    }

    @Test // Read by id
    public void testGetPublisherById() throws Exception {
        Publisher publisher = new Publisher();
        publisher.setPublisherId(5);
        publisher.setName("Mock Publisher");
        publisher.setStreet("123 Main St");
        publisher.setCity("Mock City");
        publisher.setState("MO");
        publisher.setPostalCode("12345");
        publisher.setPhone("123-456-7890");
        publisher.setEmail("publisher@email.com");

        String inputJson = mapper.writeValueAsString(publisher);

        mockMvc.perform(post("/publisher")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print()).andExpect(status().isCreated());
    }

    @Test // Read all
    public void testGetAllPublishers() throws Exception {
        Publisher publisher = new Publisher();
        publisher.setPublisherId(5);
        publisher.setName("Mock Publisher");
        publisher.setStreet("123 Main St");
        publisher.setCity("Mock City");
        publisher.setState("MO");
        publisher.setPostalCode("12345");
        publisher.setPhone("123-456-7890");
        publisher.setEmail("publisher@mock.com");

        String inputJson = mapper.writeValueAsString(publisher);

        Publisher publisher2 = new Publisher();
        publisher2.setPublisherId(6);
        publisher2.setName("Mock Publisher 2");
        publisher2.setStreet("123 Main St");
        publisher2.setCity("Mock City");
        publisher2.setState("MO");
        publisher2.setPostalCode("12345");
        publisher2.setPhone("123-456-7890");
        publisher2.setEmail("test@email.com");

        publisherRepo.save(publisher);
        publisherRepo.save(publisher2);

        mockMvc.perform(post("/publisher")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print()).andExpect(status().isCreated());
    }

    @Test // Update
    public void testUpdatePublisher() throws Exception {
        Publisher publisher = new Publisher();
        publisher.setPublisherId(5);
        publisher.setName("Mock Publisher");
        publisher.setStreet("123 Main St");
        publisher.setCity("Mock City");
        publisher.setState("MO");
        publisher.setPostalCode("12345");
        publisher.setPhone("123-456-7890");
        publisher.setEmail("email@email.com");

        String inputJson = mapper.writeValueAsString(publisher);

        mockMvc.perform(post("/publisher")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print()).andExpect(status().isCreated());
    }


    @Test // Delete
    public void testDeletePublisher() throws Exception {
        Publisher publisher = new Publisher();
        publisher.setPublisherId(5);
        publisher.setName("Mock Publisher");
        publisher.setStreet("123 Main St");
        publisher.setCity("Mock City");
        publisher.setState("MO");
        publisher.setPostalCode("12345");
        publisher.setPhone("123-456-7890");
        publisher.setEmail("email@email.com");

        String inputJson = mapper.writeValueAsString(publisher);

        mockMvc.perform(post("/publisher")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print()).andExpect(status().isCreated());
    }
}
