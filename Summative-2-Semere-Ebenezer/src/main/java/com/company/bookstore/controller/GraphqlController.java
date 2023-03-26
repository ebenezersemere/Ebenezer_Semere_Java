package com.company.bookstore.controller;

import com.company.bookstore.models.Author;
import com.company.bookstore.models.Book;
import com.company.bookstore.models.Publisher;
import com.company.bookstore.repository.AuthorRepository;
import com.company.bookstore.repository.BookRepository;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class GraphqlController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    // Find publisher by id
    @QueryMapping
    public Publisher findPublisherById(@Argument int id) {
        return publisherRepository.findById(id).orElse(null);
    }

    // Find author by id
    @QueryMapping
    public Author findAuthorById(@Argument int id) {
        return authorRepository.findById(id).orElse(null);
    }

    // Find book by id
    @QueryMapping
    public Book findBookById(@Argument int id) {
        return bookRepository.findById(id).orElse(null);
    }
}
