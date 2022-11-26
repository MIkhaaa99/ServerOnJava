package com.example.laba1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "issued_books")
public class IssuedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "book_cipher")
    public Integer bookCipher;

    @ManyToOne (optional=false, cascade=CascadeType.REMOVE)
    @JoinColumn (name="book_cipher", nullable = false, updatable = false, insertable = false)
    public Book book;

    @Column(name = "library_card")
    public Integer libraryCard;

    public Integer getBookCipher() {
        return bookCipher;
    }

    public void setBookCipher(Integer bookCipher) {
        this.bookCipher = bookCipher;
    }

    public Integer getLibraryCard() {
        return libraryCard;
    }

    public void setLibraryCard(Integer libraryCard) {
        this.libraryCard = libraryCard;
    }

    @ManyToOne (optional=false, cascade=CascadeType.REMOVE)
    @JoinColumn (name="library_card", nullable = false, updatable = false, insertable = false)
    public Reader reader;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
    @Column(name = "date_of_issue")
    public Date dateOfIssue;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
    @Column(name = "date_of_return")
    public Date dateOfReturn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
    @Column(name = "date_of_actual_return")
    public Date dateOfActualReturn;

    public IssuedBook() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public Date getDateOfActualReturn() {
        return dateOfActualReturn;
    }

    public void setDateOfActualReturn(Date dateOfActualReturn) {
        this.dateOfActualReturn = dateOfActualReturn;
    }
}
