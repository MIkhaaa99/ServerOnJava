package com.example.laba1.repository;

import com.example.laba1.entity.IssuedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuedBookRepository extends JpaRepository<IssuedBook, Integer> {
}
