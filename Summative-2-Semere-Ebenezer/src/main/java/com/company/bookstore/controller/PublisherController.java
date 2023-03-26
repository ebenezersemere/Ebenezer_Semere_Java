package com.company.bookstore.controller;

import com.company.bookstore.models.Publisher;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {
    @Autowired
    private PublisherRepository publisherRepository;

    // Create
    @PostMapping("/publisher")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher createPublisher(@RequestBody Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    // Read by id
    @GetMapping("/publisher/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher getPublisherById(@PathVariable int id) {
        return publisherRepository.findById(id).orElse(null);
    }

    // Read all
    @GetMapping("/publishers")
    @ResponseStatus(HttpStatus.OK)
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    // Update
    @PutMapping("/publisher/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePublisher(@PathVariable int id, @RequestBody Publisher publisher) {
        Optional<Publisher> publisherOptional = publisherRepository.findById(id);
        if (publisherOptional.isPresent()) {
            Publisher oldPublisher = getPublisherById(id);
            oldPublisher.setName(publisher.getName());
            oldPublisher.setStreet(publisher.getStreet());
            oldPublisher.setCity(publisher.getCity());
            oldPublisher.setState(publisher.getState());
            oldPublisher.setPostalCode(publisher.getPostalCode());
            oldPublisher.setPhone(publisher.getPhone());
            oldPublisher.setEmail(publisher.getEmail());
            publisherRepository.save(oldPublisher);
        }
    }

    // Delete
    @DeleteMapping("/publisher/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable int id) {
        Optional<Publisher> publisherOptional = publisherRepository.findById(id);
        if (publisherOptional.isPresent()) {
            publisherRepository.deleteById(id);
        }
    }
}
