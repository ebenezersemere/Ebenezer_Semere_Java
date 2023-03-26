package com.company.bookstore.repository;

import com.company.bookstore.models.Author;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorRepositoryTest {
    @Autowired
    private AuthorRepository authorRepo;

    @Before
    public void setUp() throws Exception {
        authorRepo.deleteAll();
    }

    @Test
    public void testAddAuthor() {
        Author author = new Author();
        author.setFirstName("Mock");
        author.setLastName("Author");
        author.setStreet("Mock Street");
        author.setCity("Mock City");
        author.setState("NY");
        author.setPostalCode("43964");
        author.setPhone("740-123-4567");
        author.setEmail("JohnDoe@gmail.com");

        author = authorRepo.save(author);

        Optional<Author> authorMock = authorRepo.findById(author.getAuthorId());

        assertEquals(authorMock.get(), author);
    }

    @Test
    public void testGetAllAuthors() {
        Author author = new Author();
        author.setFirstName("Mock");
        author.setLastName("Author");
        author.setStreet("Mock Street");
        author.setCity("Mock City");
        author.setState("NY");
        author.setPostalCode("43964");
        author.setPhone("740-123-4567");
        author.setEmail("author@email.com");

        author = authorRepo.save(author);

        Author author2 = new Author();
        author2.setFirstName("Mock2");
        author2.setLastName("Author2");
        author2.setStreet("Mock Street2");
        author2.setCity("NY");
        author2.setState("NY");
        author2.setPostalCode("43964");
        author2.setPhone("740-123-4567");
        author2.setEmail("author2@email.com");

        author2 = authorRepo.save(author2);

        assertEquals(2, authorRepo.findAll().size());
    }

    @Test
    public void testUpdateAuthor() {
        Author author = new Author();
        author.setFirstName("Mock");
        author.setLastName("Author");
        author.setStreet("Mock Street");
        author.setCity("Mock City");
        author.setState("NY");
        author.setPostalCode("43964");
        author.setPhone("740-123-4567");
        author.setEmail("email@email.com");

        author = authorRepo.save(author);

        author.setFirstName("Mock2");
        author.setLastName("Author2");

        authorRepo.save(author);

        Optional<Author> authorMock = authorRepo.findById(author.getAuthorId());
        assertEquals(authorMock.get(), author);
    }

    @Test
    public void testDeleteAuthor() {
        Author author = new Author();
        author.setFirstName("Mock");
        author.setLastName("Author");
        author.setStreet("Mock Street");
        author.setCity("Mock City");
        author.setState("NY");
        author.setPostalCode("43964");
        author.setPhone("740-123-4567");
        author.setEmail("email@email.com");

        author = authorRepo.save(author);

        authorRepo.delete(author);

        Optional<Author> authorMock = authorRepo.findById(author.getAuthorId());
        assertEquals(Optional.empty(), authorMock);
    }

    @Test
    public void testGetAuthorById() {
        Author author = new Author();
        author.setFirstName("Mock");
        author.setLastName("Author");
        author.setStreet("Mock Street");
        author.setCity("Mock City");
        author.setState("NY");
        author.setPostalCode("43964");
        author.setPhone("740-123-4567");
        author.setEmail("email@email.com");

        author = authorRepo.save(author);

        Optional<Author> authorMock = authorRepo.findById(author.getAuthorId());
        assertEquals(authorMock.get(), author);
    }
}
