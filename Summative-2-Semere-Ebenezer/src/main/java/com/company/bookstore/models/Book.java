package com.company.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    private String isbn;
    private LocalDate publishDate;
    private int authorId;
    private String title;
    private int publisherId;
    private BigDecimal price;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getBookId() == book.getBookId() && getAuthorId() == book.getAuthorId() && getPublisherId() == book.getPublisherId() && Objects.equals(getIsbn(), book.getIsbn()) && Objects.equals(getPublishDate(), book.getPublishDate()) && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getPrice(), book.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getIsbn(), getPublishDate(), getAuthorId(), getTitle(), getPublisherId(), getPrice());
    }
}
