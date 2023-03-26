package com.company.bookstore.controller;

import com.company.bookstore.models.Book;
import com.company.bookstore.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository bookRepo;

    @Autowired
    private ObjectMapper mapper;

    private List<Book> bookList;

    @Test // Create
    public void testAddBook() throws Exception {
        Book book = new Book();
        book.setBookId(5);
        book.setTitle("Mock Book");
        book.setAuthorId(1);
        book.setPublisherId(1);
        book.setPrice(BigDecimal.valueOf(9.99));
        book.setIsbn("1234567890");
        book.setPublishDate(LocalDate.parse("2020-01-01"));

        String inputJson = mapper.writeValueAsString(book);

        mockMvc.perform(post("/book")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test // Read by id
    public void testGetBookById() throws Exception {
        Book book = new Book();
        book.setBookId(5);
        book.setTitle("Mock Book");
        book.setAuthorId(1);
        book.setPublisherId(1);
        book.setPrice(BigDecimal.valueOf(9.99));
        book.setIsbn("1234567890");
        book.setPublishDate(LocalDate.parse("2020-01-01"));

        String inputJson = mapper.writeValueAsString(book);

        mockMvc.perform(MockMvcRequestBuilders.get("/book/5")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test // Read all
    public void testReadAllBooks() throws Exception {
        Book book = new Book();
        book.setBookId(5);
        book.setTitle("Mock Book");
        book.setAuthorId(1);
        book.setPublisherId(1);
        book.setPrice(BigDecimal.valueOf(9.99));
        book.setIsbn("1234567890");
        book.setPublishDate(LocalDate.parse("2020-01-01"));

        Book book2 = new Book();
        book2.setBookId(6);
        book2.setTitle("Mock Book 2");
        book2.setAuthorId(1);
        book2.setPublisherId(1);
        book2.setPrice(BigDecimal.valueOf(9.99));
        book2.setIsbn("1234567890");
        book2.setPublishDate(LocalDate.parse("2020-01-01"));

        Book book3 = new Book();
        book3.setBookId(7);
        book3.setTitle("Mock Book 3");
        book3.setAuthorId(1);
        book3.setPublisherId(1);
        book3.setPrice(BigDecimal.valueOf(9.99));
        book3.setIsbn("1234567890");
        book3.setPublishDate(LocalDate.parse("2020-01-01"));

        bookRepo.save(book);
        bookRepo.save(book2);
        bookRepo.save(book3);

        mockMvc.perform(MockMvcRequestBuilders.get("/books"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test // Update
    public void testUpdateBook() throws Exception {
        Book book = new Book();
        book.setBookId(5);
        book.setTitle("Mock Book");
        book.setAuthorId(1);
        book.setPublisherId(1);
        book.setPrice(BigDecimal.valueOf(9.99));
        book.setIsbn("1234567890");
        book.setPublishDate(LocalDate.parse("2020-01-01"));

        String inputJson = mapper.writeValueAsString(book);

        mockMvc.perform(MockMvcRequestBuilders.put("/book/5")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test // Delete
    public void testDeleteBook() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/book/5"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test // Search by id
    public void testGetBookByAuthorId() throws Exception {
        Book book = new Book();
        book.setBookId(5);
        book.setTitle("Mock Book");
        book.setAuthorId(1);
        book.setPublisherId(1);
        book.setPrice(BigDecimal.valueOf(9.99));
        book.setIsbn("1234567890");
        book.setPublishDate(LocalDate.parse("2020-01-01"));

        String inputJson = mapper.writeValueAsString(book);

        mockMvc.perform(MockMvcRequestBuilders.get("/books/author/1")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
