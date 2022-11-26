package com.example.laba1.service;

import com.example.laba1.entity.Book;
import com.example.laba1.entity.IssuedBook;
import com.example.laba1.entity.Reader;
import com.example.laba1.repository.BookRepository;
import com.example.laba1.repository.IssuedBookRepository;
import com.example.laba1.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
public class IssuedBookService {

    @Autowired
    private IssuedBookRepository issuedBookRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReaderRepository readerRepository;

    public List<IssuedBook> findAll() {
        return issuedBookRepository.findAll();
    }

    public void save(IssuedBook issuedBookCandidate) throws Exception {
        Book book = bookRepository.findById(issuedBookCandidate.bookCipher).get();
        Reader reader = readerRepository.findById(issuedBookCandidate.libraryCard).get();
        if(book.quantity <= 0) {
            throw new Exception("Нет книг в наличии!");
        }
        book.setQuantity(book.getQuantity() - 1);
        IssuedBook issuedBook = new IssuedBook();
        issuedBook.setDateOfIssue(issuedBookCandidate.getDateOfIssue());
        issuedBook.setDateOfActualReturn(issuedBookCandidate.getDateOfActualReturn());
        issuedBook.setDateOfReturn(issuedBookCandidate.getDateOfReturn());
        issuedBook.setBook(book);
        issuedBook.setReader(reader);
        issuedBook.setBookCipher(issuedBookCandidate.bookCipher);
        issuedBook.setLibraryCard(issuedBookCandidate.libraryCard);
        issuedBookRepository.save(issuedBook);
    }

    public void save(Map<String, Object> issuedBookCandidate, Integer id) throws Exception {
        IssuedBook issuedBook = issuedBookRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("issuedBook does not exist with id: " + id));
        for (Map.Entry<String, Object> entry : issuedBookCandidate.entrySet()) {
            String k = entry.getKey();
            Object v = entry.getValue();
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("dd-MM-yyyy");
            Date docDate= (Date) format.parse((String) v);
            issuedBook.setDateOfActualReturn(docDate);
        }
        issuedBook.book.setQuantity(issuedBook.book.getQuantity() + 1);
        issuedBookRepository.save(issuedBook);
    }
}
