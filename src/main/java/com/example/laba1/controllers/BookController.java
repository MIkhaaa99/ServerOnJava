package com.example.laba1.controllers;

import com.example.laba1.entity.Book;
import com.example.laba1.service.BookService;
import com.example.laba1.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    @Autowired
    public BookService bookService;

    @JsonView({View.REST.class})
    @GetMapping("/books")
    public List<Book> getBooks(@RequestParam(required = false) Integer yearOfPublication, @RequestParam(required = false) String author) {
        if(yearOfPublication == null && author == null) {
            return bookService.findAll();
        }
        else if (yearOfPublication != null && author != null) {
            return bookService.getBooksByYearAndAuthor(yearOfPublication, author);
        }
        else if (author != null) {
            return bookService.getBooksByAuthor(author);
        }
        else {
            return bookService.getBooksByYear(yearOfPublication);
        }
    }

    @PostMapping("/books")
    public ResponseEntity postBook(@RequestBody Book book) {
        try {
            bookService.save(book);
            return ResponseEntity.status(HttpStatus.OK).body("Success!");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error!");
        }
    }

    @PatchMapping("/books/{id}")
    public ResponseEntity patchBook(@RequestBody Map<String, Object> updates, @PathVariable("id") Integer id) {
        try {
            bookService.save(updates, id);
            return ResponseEntity.status(HttpStatus.OK).body("Success!");
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
