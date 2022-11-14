package com.example.laba1.repository;

import com.example.laba1.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReaderRepository extends JpaRepository<Reader, Integer> {

    List<Reader> findBySurnameAndNameAndPatronymicAndAddress(String surname,
                                                             String name,
                                                             String patronymic,
                                                             String address);
}
