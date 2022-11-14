package com.example.laba1.repository;

import com.example.laba1.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByAuthorAndNameAndYearOfPublication(String author,
                                                       String name,
                                                       Integer yearOfPublication);

    @Query("SELECT book FROM Book book WHERE book.yearOfPublication >= ?1")
    public List<Book> getBooksByYear(Integer year);

    @Query("SELECT book FROM Book book WHERE book.author >= ?1")
    public List<Book> getBooksByAuthor(String author);

    @Query("SELECT book FROM Book book WHERE book.yearOfPublication >= ?1 AND book.author = ?2")
    public List<Book> getBooksByYearAndAuthor(Integer year, String author);
}
