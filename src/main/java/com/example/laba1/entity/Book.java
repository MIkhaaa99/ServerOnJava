package com.example.laba1.entity;

import com.example.laba1.view.View;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({View.REST.class})
    @Column(name = "book_cipher")
    public Integer bookCipher;

    @JsonView({View.REST.class})
    @Column(name = "author")
    public String author;

    @JsonView({View.REST.class})
    @Column(name = "name")
    public String name;

    @JsonView({View.REST.class})
    @Column(name = "year_of_publication")
    public Integer yearOfPublication;

    @JsonView({View.REST.class})
    @Column(name = "quantity")
    public Integer quantity;

    @OneToMany(mappedBy = "book", fetch=FetchType.EAGER)
    @JsonIgnore
    public List<IssuedBook> books;

    public Book() {

    }

    public void setBookCipher(Integer bookCipher) {
        this.bookCipher = bookCipher;
    }

    public List<IssuedBook> getBooks() {
        return books;
    }

    public void setBooks(List<IssuedBook> books) {
        this.books = books;
    }

    public Integer getBookCipher() {
        return bookCipher;
    }

    public void setBookCipher(int bookCipher) {
        this.bookCipher = bookCipher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
