package com.company.bookstore.repository;

import com.company.bookstore.models.Author;
import com.company.bookstore.models.Book;
import com.company.bookstore.models.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublisherRepositoryTest {
    @Autowired
    PublisherRepository publisherRepo;

    @Before
    public void setUp() throws Exception {
        publisherRepo.deleteAll();
    }

    @Test
    public void testAddPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Mock Publisher");
        publisher.setStreet("MockStreet");
        publisher.setCity("MockCity");
        publisher.setState("NY");
        publisher.setPostalCode("43964");
        publisher.setPhone("740-123-4567");
        publisher.setEmail("publisher@email.com");

        publisher = publisherRepo.save(publisher);

        Optional<Publisher> publisherMock = publisherRepo.findById(publisher.getPublisherId());

        assertEquals(publisherMock.get(), publisher);
    }

    @Test
    public void testGetAllPublishers() {
        Publisher publisher = new Publisher();
        publisher.setName("Mock Publisher");
        publisher.setStreet("MockStreet");
        publisher.setCity("MockCity");
        publisher.setState("NY");
        publisher.setPostalCode("43964");
        publisher.setPhone("740-123-4567");
        publisher.setEmail("publisher@email.com");

        publisher = publisherRepo.save(publisher);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Mock Publisher 2");
        publisher2.setStreet("MockStreet 2");
        publisher2.setCity("MockCity 2");
        publisher2.setState("NY");
        publisher2.setPostalCode("43964");
        publisher2.setPhone("740-123-4567");
        publisher2.setEmail("emaiL@email.com");

        publisher2 = publisherRepo.save(publisher2);

        assertEquals(2, publisherRepo.findAll().size());

    }

    @Test
    public void testUpdatePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Mock Publisher");
        publisher.setStreet("MockStreet");
        publisher.setCity("MockCity");
        publisher.setState("NY");
        publisher.setPostalCode("43964");
        publisher.setPhone("740-123-4567");
        publisher.setEmail("publisher@email.com");

        publisher = publisherRepo.save(publisher);

        publisher.setName("Mock Publisher 2");

        publisher = publisherRepo.save(publisher);

        assertEquals("Mock Publisher 2", publisher.getName());
    }

    @Test
    public void testDeletePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Mock Publisher");
        publisher.setStreet("MockStreet");
        publisher.setCity("MockCity");
        publisher.setState("NY");
        publisher.setPostalCode("43964");
        publisher.setPhone("740-123-4567");
        publisher.setEmail("publisher@email.com");

        publisher = publisherRepo.save(publisher);

        publisherRepo.delete(publisher);

        assertEquals(0, publisherRepo.findAll().size());
    }

    @Test
    public void testGetPublisherById() {
        Publisher publisher = new Publisher();
        publisher.setName("Mock Publisher");
        publisher.setStreet("MockStreet");
        publisher.setCity("MockCity");
        publisher.setState("NY");
        publisher.setPostalCode("43964");
        publisher.setPhone("740-123-4567");
        publisher.setEmail("publisher@email.com");

        publisher = publisherRepo.save(publisher);

        Optional<Publisher> publisherMock = publisherRepo.findById(publisher.getPublisherId());

        assertEquals(publisherMock.get(), publisher);
    }

}
