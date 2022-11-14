package com.example.laba1.service;

import com.example.laba1.entity.Reader;
import com.example.laba1.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    public List<Reader> findAll() {
        return readerRepository.findAll();
    }

    public void save(Reader reader) throws Exception {
        List<Reader> readerList = readerRepository.findBySurnameAndNameAndPatronymicAndAddress(
                reader.surname,
                reader.name,
                reader.patronymic,
                reader.address
        );
        if(readerList.isEmpty()) {
            readerRepository.save(reader);
        }
        else {
            throw new Exception();
        }
    }
}
