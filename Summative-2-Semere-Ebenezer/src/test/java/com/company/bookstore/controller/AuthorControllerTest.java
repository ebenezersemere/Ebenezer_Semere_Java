package com.company.bookstore.controller;

import com.company.bookstore.models.Author;
import com.company.bookstore.repository.AuthorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorRepository authorRepo;

    private Author mockAuthor;

    @BeforeEach
    public void setUp() {
        authorRepo.deleteAll();
    }

    @Test // Create
    public void testAddAuthor() throws Exception {
        mockAuthor = new Author();
        mockAuthor.setAuthorId(1);
        mockAuthor.setFirstName("Mock");
        mockAuthor.setLastName("Author");
        mockAuthor.setStreet("Mock Street");
        mockAuthor.setCity("Mock City");
        mockAuthor.setState("Mock State");
        mockAuthor.setPostalCode("12345");
        mockAuthor.setPhone("123-456-7890");
        mockAuthor.setEmail("mock@email.com");

        when(authorRepo.save(any(Author.class))).thenReturn(mockAuthor);

        String inputJson = new ObjectMapper().writeValueAsString(mockAuthor);

        mockMvc.perform(MockMvcRequestBuilders.post("/author")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputJson))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.authorId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Mock"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Author"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.street").value("Mock Street"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.city").value("Mock City"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.state").value("Mock State"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.postalCode").value("12345"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone").value("123-456-7890"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("mock@email.com"));

        verify(authorRepo, times(1)).save(any(Author.class));
    }

    @Test // Read by id
    public void testGetAuthorById() throws Exception {
        mockAuthor = new Author();
        mockAuthor.setAuthorId(1);
        mockAuthor.setFirstName("Mock");
        mockAuthor.setLastName("Author");
        mockAuthor.setStreet("Mock Street");
        mockAuthor.setCity("Mock City");
        mockAuthor.setState("Mock State");
        mockAuthor.setPostalCode("12345");
        mockAuthor.setPhone("123-456-7890");
        mockAuthor.setEmail("mock@email.com");

        when(authorRepo.findById(anyInt())).thenReturn(Optional.of(mockAuthor));

        mockMvc.perform(MockMvcRequestBuilders.get("/author/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.authorId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Mock"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Author"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.street").value("Mock Street"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.city").value("Mock City"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.state").value("Mock State"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.postalCode").value("12345"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone").value("123-456-7890"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("mock@email.com"));
    }

    @Test // Read all
    public void testGetAllAuthors() throws Exception {
        Author mockAuthor = new Author();
        mockAuthor.setAuthorId(1);
        mockAuthor.setFirstName("Mock");
        mockAuthor.setLastName("Author");
        mockAuthor.setStreet("Mock Street");
        mockAuthor.setCity("Mock City");
        mockAuthor.setState("Mock State");
        mockAuthor.setPostalCode("12345");
        mockAuthor.setPhone("123-456-7890");
        mockAuthor.setEmail("mock@email.com");

        Author author2 = new Author();
        author2.setAuthorId(2);
        author2.setFirstName("Mock2");
        author2.setLastName("Author2");
        author2.setStreet("Mock Street2");
        author2.setCity("Mock City2");
        author2.setState("Mock State2");
        author2.setPostalCode("123452");
        author2.setPhone("123-456-78902");
        author2.setEmail("mock2@email.com");
        authorRepo.save(author2);

        List<Author> mockAuthorList = Arrays.asList(mockAuthor, author2);

        when(authorRepo.findAll()).thenReturn(mockAuthorList);

        mockMvc.perform(MockMvcRequestBuilders.get("/author"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].authorId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").value("Mock"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].lastName").value("Author"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].street").value("Mock Street"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].city").value("Mock City"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].state").value("Mock State"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].postalCode").value("12345"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].phone").value("123-456-7890"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("mock@email.com"));
    }

    @Test // Update
    public void testUpdateAuthor() throws Exception {
        mockAuthor = new Author();
        mockAuthor.setAuthorId(1);
        mockAuthor.setFirstName("Mock");
        mockAuthor.setLastName("Author");
        mockAuthor.setStreet("Mock Street");
        mockAuthor.setCity("Mock City");
        mockAuthor.setState("Mock State");
        mockAuthor.setPostalCode("12345");
        mockAuthor.setPhone("123-456-7890");
        mockAuthor.setEmail("mock@email.com");

        Author updatedAuthor = new Author();
        updatedAuthor.setAuthorId(1);
        updatedAuthor.setFirstName("UpdatedFirstName");
        updatedAuthor.setLastName("UpdatedLastName");
        updatedAuthor.setStreet("UpdatedStreet");
        updatedAuthor.setCity("UpdatedCity");
        updatedAuthor.setState("UpdatedState");
        updatedAuthor.setPostalCode("UpdatedPostalCode");
        updatedAuthor.setPhone("UpdatedPhone");
        updatedAuthor.setEmail("UpdatedEmail");

        when(authorRepo.save(any(Author.class))).thenReturn(updatedAuthor);
    }

    @Test // Delete
    public void testDeleteAuthor() throws Exception {
        mockAuthor = new Author();
        mockAuthor.setAuthorId(1);
        mockAuthor.setFirstName("Mock");
        mockAuthor.setLastName("Author");
        mockAuthor.setStreet("Mock Street");
        mockAuthor.setCity("Mock City");
        mockAuthor.setState("Mock State");
        mockAuthor.setPostalCode("12345");
        mockAuthor.setPhone("123-456-7890");
        mockAuthor.setEmail("mock@email.com");

        authorRepo.save(mockAuthor);

        authorRepo.deleteById(mockAuthor.getAuthorId());

        Optional<Author> deletedAuthor = authorRepo.findById(mockAuthor.getAuthorId());

        Assertions.assertFalse(deletedAuthor.isPresent());
    }
}