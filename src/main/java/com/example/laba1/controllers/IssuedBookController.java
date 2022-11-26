package com.example.laba1.controllers;

import com.example.laba1.entity.IssuedBook;
import com.example.laba1.service.IssuedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        try {
            issuedBookService.save(issuedBook);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body("Success!");
    }

    @PatchMapping("/issuedBooks/{id}")
    public ResponseEntity patchIssuedBooks(@RequestBody Map<String, Object> updates, @PathVariable("id") Integer id) {
        try {
            issuedBookService.save(updates, id);
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
