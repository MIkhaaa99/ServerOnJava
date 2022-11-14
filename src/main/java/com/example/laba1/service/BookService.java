package com.example.laba1.service;

import com.example.laba1.entity.Book;
import com.example.laba1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksByYear(Integer year) {
        return bookRepository.getBooksByYear(year);
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.getBooksByAuthor(author);
    }

    public List<Book> getBooksByYearAndAuthor(Integer year, String author) {
        return bookRepository.getBooksByYearAndAuthor(year, author);
    }

    public void save(Book book) throws Exception {
        List<Book> bookList = bookRepository.findByAuthorAndNameAndYearOfPublication(
                book.author,
                book.name,
                book.yearOfPublication);
        if (bookList.isEmpty()) {
            bookRepository.save(book);
        } else {
            throw new Exception();
        }
    }

    public void save(Map<String, Object> books, Integer id) throws Exception {
        Book bookCandidate = bookRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("book does not exist with id: " + id));
        for (Map.Entry<String, Object> entry : books.entrySet()) {
            String k = entry.getKey();
            Object v = entry.getValue();
            if ((Integer) books.get(k) >= 0) {
                bookCandidate.quantity = (Integer) books.get(k);
            } else {
                throw new Exception("quantity can't be smaller than 0!");
            }
        }
        bookRepository.save(bookCandidate);
    }
}
