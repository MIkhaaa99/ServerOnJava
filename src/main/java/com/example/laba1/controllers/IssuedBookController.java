package com.example.laba1.controllers;

import com.example.laba1.entity.IssuedBook;
import com.example.laba1.entity.Reader;
import com.example.laba1.service.IssuedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IssuedBookController {

    @Autowired
    private IssuedBookService issuedBookService;

    @GetMapping("/issuedBooks")
    public List<IssuedBook> getReaders() {
        return issuedBookService.findAll();
    }

    @PostMapping("/issuedBooks")
    public ResponseEntity postIssuedBook(@RequestBody IssuedBook issuedBook) {
        issuedBookService.save(issuedBook);
        return ResponseEntity.status(HttpStatus.OK).body("Success!");
    }
}
