package com.example.laba1.service;

import com.example.laba1.entity.IssuedBook;
import com.example.laba1.repository.IssuedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssuedBookService {

    @Autowired
    private IssuedBookRepository issuedBookRepository;

    public List<IssuedBook> findAll() {
        return issuedBookRepository.findAll();
    }

    public void save(IssuedBook issuedBook) {
        issuedBookRepository.save(issuedBook);
    }
}
