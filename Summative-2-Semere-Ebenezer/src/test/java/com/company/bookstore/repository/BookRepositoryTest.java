package com.company.bookstore.repository;

import com.company.bookstore.models.Book;
import com.company.bookstore.models.Author;
import com.company.bookstore.models.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private AuthorRepository authorRepo;

    @Autowired
    private PublisherRepository publisherRepo;

    @Before
    public void setUp() throws Exception {
        bookRepo.deleteAll();
        publisherRepo.deleteAll();
        authorRepo.deleteAll();
    }

    @Test
    public void testAddBook() {
        Author author = new Author();
        author.setFirstName("Mock");
        author.setLastName("Author");
        author.setStreet("MockStreet");
        author.setCity("MockCity");
        author.setState("NY");
        author.setPostalCode("43964");
        author.setPhone("740-123-4567");
        author.setEmail("author@email.com");

        author = authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Mock Publisher");
        publisher.setStreet("MockStreet");
        publisher.setCity("MockCity");
        publisher.setState("NY");
        publisher.setPostalCode("43964");
        publisher.setPhone("740-123-4567");
        publisher.setEmail("publisher@email.com");

        publisher = publisherRepo.save(publisher);

        Book book = new Book();
        book.setTitle("Mock Book");
        book.setIsbn("123456789");
        book.setPublishDate(LocalDate.parse("2019-01-01"));
        book.setPublisherId(publisher.getPublisherId());
        book.setAuthorId(author.getAuthorId());
        book.setPrice(BigDecimal.valueOf(19.99));

        book = bookRepo.save(book);

        Book book1 = bookRepo.findById(book.getBookId()).get();

        assertEquals(book1, book);
    }

    @Test
    public void testGetAllBooks() {
        Author author = new Author();
        author.setFirstName("Mock");
        author.setLastName("Author");
        author.setStreet("MockStreet");
        author.setCity("MockCity");
        author.setState("NY");
        author.setPostalCode("43964");
        author.setPhone("740-123-4567");
        author.setEmail("author@email.com");

        author = authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Mock Publisher");
        publisher.setStreet("MockStreet");
        publisher.setCity("MockCity");
        publisher.setState("NY");
        publisher.setPostalCode("43964");
        publisher.setPhone("740-123-4567");
        publisher.setEmail("publisher@email.com");

        publisher = publisherRepo.save(publisher);

        Book book = new Book();
        book.setTitle("Mock Book");
        book.setIsbn("123456789");
        book.setPublishDate(LocalDate.parse("2019-01-01"));
        book.setPublisherId(publisher.getPublisherId());
        book.setAuthorId(author.getAuthorId());
        book.setPrice(BigDecimal.valueOf(19.99));

        book = bookRepo.save(book);

        Book book2 = new Book();
        book2.setTitle("Mock Book 2");
        book2.setIsbn("123456789");
        book2.setPublishDate(LocalDate.parse("2019-01-01"));
        book2.setPublisherId(publisher.getPublisherId());
        book2.setAuthorId(author.getAuthorId());
        book2.setPrice(BigDecimal.valueOf(29.99));

        book2 = bookRepo.save(book2);

        assertEquals(2, bookRepo.findAll().size());
    }

    @Test
    public void testUpdateBook() {
        Author author = new Author();
        author.setFirstName("Mock");
        author.setLastName("Author");
        author.setStreet("MockStreet");
        author.setCity("MockCity");
        author.setState("NY");
        author.setPostalCode("43964");
        author.setPhone("740-123-4567");
        author.setEmail("author@email.com");

        author = authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Mock Publisher");
        publisher.setStreet("MockStreet");
        publisher.setCity("MockCity");
        publisher.setState("NY");
        publisher.setPostalCode("43964");
        publisher.setPhone("740-123-4567");
        publisher.setEmail("publisher@email.com");

        publisher = publisherRepo.save(publisher);
        author = authorRepo.save(author);

        Book book = new Book();
        book.setTitle("Mock Book");
        book.setIsbn("123456789");
        book.setPublishDate(LocalDate.parse("2019-01-01"));
        book.setPublisherId(publisher.getPublisherId());
        book.setAuthorId(author.getAuthorId());
        book.setPrice(BigDecimal.valueOf(19.99));

        book = bookRepo.save(book);

        book.setTitle("Mock Book 2");

        book = bookRepo.save(book);

        Book book1 = bookRepo.findById(book.getBookId()).get();

        assertEquals(book1, book);
    }

    @Test
    public void testDeleteBook() {
        Author author = new Author();
        author.setFirstName("Mock");
        author.setLastName("Author");
        author.setStreet("MockStreet");
        author.setCity("MockCity");
        author.setState("NY");
        author.setPostalCode("43964");
        author.setPhone("740-123-4567");
        author.setEmail("author@email.com");

        author = authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Mock Publisher");
        publisher.setStreet("MockStreet");
        publisher.setCity("MockCity");
        publisher.setState("NY");
        publisher.setPostalCode("43964");
        publisher.setPhone("740-123-4567");
        publisher.setEmail("publisher@email.com");

        publisher = publisherRepo.save(publisher);
        author = authorRepo.save(author);

        Book book = new Book();
        book.setTitle("Mock Book");
        book.setIsbn("123456789");
        book.setPublishDate(LocalDate.parse("2019-01-01"));
        book.setPublisherId(publisher.getPublisherId());
        book.setAuthorId(author.getAuthorId());
        book.setPrice(BigDecimal.valueOf(19.99));

        book = bookRepo.save(book);

        bookRepo.deleteById(book.getBookId());

        assertEquals(0, bookRepo.findAll().size());
    }

    @Test
    public void testGetBookById() {
        Author author = new Author();
        author.setFirstName("Mock");
        author.setLastName("Author");
        author.setStreet("MockStreet");
        author.setCity("MockCity");
        author.setState("NY");
        author.setPostalCode("43964");
        author.setPhone("740-123-4567");
        author.setEmail("author@email.com");

        author = authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Mock Publisher");
        publisher.setStreet("MockStreet");
        publisher.setCity("MockCity");
        publisher.setState("NY");
        publisher.setPostalCode("43964");
        publisher.setPhone("740-123-4567");
        publisher.setEmail("publisher@email.com");

        publisher = publisherRepo.save(publisher);
        author = authorRepo.save(author);

        Book book = new Book();
        book.setTitle("Mock Book");
        book.setIsbn("123456789");
        book.setPublishDate(LocalDate.parse("2019-01-01"));
        book.setPublisherId(publisher.getPublisherId());
        book.setAuthorId(author.getAuthorId());
        book.setPrice(BigDecimal.valueOf(19.99));

        book = bookRepo.save(book);

        Book book1 = bookRepo.findById(book.getBookId()).get();

        assertEquals(book1, book);
    }

    @Test
    public void testGetBooksByAuthor() {
        Author author = new Author();
        author.setFirstName("Mock");
        author.setLastName("Author");
        author.setStreet("MockStreet");
        author.setCity("MockCity");
        author.setState("NY");
        author.setPostalCode("43964");
        author.setPhone("740-123-4567");
        author.setEmail("author@email.com");

        author = authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Mock Publisher");
        publisher.setStreet("MockStreet");
        publisher.setCity("MockCity");
        publisher.setState("NY");
        publisher.setPostalCode("43964");
        publisher.setPhone("740-123-4567");
        publisher.setEmail("publisher@email.com");

        publisher = publisherRepo.save(publisher);
        author = authorRepo.save(author);

        Book book = new Book();
        book.setTitle("Mock Book");
        book.setIsbn("123456789");
        book.setPublishDate(LocalDate.parse("2019-01-01"));
        book.setPublisherId(publisher.getPublisherId());
        book.setAuthorId(author.getAuthorId());
        book.setPrice(BigDecimal.valueOf(19.99));

        book = bookRepo.save(book);

        List<Book> books = bookRepo.findByAuthorId(author.getAuthorId());

        assertEquals(1, books.size());
    }
}
