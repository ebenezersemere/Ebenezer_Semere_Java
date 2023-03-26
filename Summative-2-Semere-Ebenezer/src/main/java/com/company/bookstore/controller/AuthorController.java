package com.company.bookstore.controller;

import com.company.bookstore.models.Author;
import com.company.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    // Create
    @PostMapping("/author")
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    // Read by id
    @GetMapping("/author/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthorById(@PathVariable int id) {
        Optional<Author> author = authorRepository.findById(id);
        return author.orElse(null);
    }

    // Read all
    @GetMapping("/author")
    @ResponseStatus(HttpStatus.OK)
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // Update
    @PutMapping("/author/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAuthor(@PathVariable int id, @RequestBody Author author) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isPresent()) {
            Author oldAuthor = getAuthorById(id);
            oldAuthor.setFirstName(author.getFirstName());
            oldAuthor.setLastName(author.getLastName());
            oldAuthor.setStreet(author.getStreet());
            oldAuthor.setCity(author.getCity());
            oldAuthor.setState(author.getState());
            oldAuthor.setPostalCode(author.getPostalCode());
            oldAuthor.setEmail(author.getEmail());
            oldAuthor.setPhone(author.getPhone());
            authorRepository.save(oldAuthor);
        }
    }

    // Delete
    @DeleteMapping("/author/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent())
            authorRepository.deleteById(id);
    }

}
