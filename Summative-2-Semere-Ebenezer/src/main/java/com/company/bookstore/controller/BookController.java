package com.company.bookstore.controller;

import com.company.bookstore.models.Book;
import com.company.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    // Create
    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // Read by id
    @GetMapping("/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable int id) {
        return bookRepository.findById(id).orElse(null);
    }

    // Read all
    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Update
    @PutMapping("/book/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@PathVariable int id, @RequestBody Book book){
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()){
            Book oldBook = getBookById(id);
            oldBook.setTitle(book.getTitle());
            oldBook.setAuthorId(book.getAuthorId());
            oldBook.setPublisherId(book.getPublisherId());
            oldBook.setIsbn(book.getIsbn());
            oldBook.setPublishDate(book.getPublishDate());
            oldBook.setPrice(book.getPrice());
            bookRepository.save(oldBook);
        }
    }

    // Delete
    @DeleteMapping("/book/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            bookRepository.deleteById(id);
        }
    }

    // Search by author id
    @GetMapping("/books/author/{authorId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooksByAuthorId(@PathVariable int authorId) {
        return bookRepository.findByAuthorId(authorId);
    }
}
