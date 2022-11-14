package com.example.laba1.controllers;

import com.example.laba1.entity.Reader;
import com.example.laba1.service.ReaderService;
import com.example.laba1.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReaderController {

    @Autowired
    public ReaderService readerService;

    @JsonView({View.REST.class})
    @GetMapping("/readers")
    public List<Reader> getReaders() {
        return readerService.findAll();
    }

    @PostMapping("/readers")
    public ResponseEntity postReader(@RequestBody Reader reader) {
        try {
            readerService.save(reader);
            return ResponseEntity.status(HttpStatus.OK).body("Success!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error!");
        }
    }
}
