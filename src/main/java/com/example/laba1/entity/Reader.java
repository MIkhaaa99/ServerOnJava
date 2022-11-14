package com.example.laba1.entity;

import com.example.laba1.view.View;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "readers")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({View.REST.class})
    @Column(name = "library_card")
    public Integer libraryCard;

    @JsonView({View.REST.class})
    @Column(name = "surname")
    public String surname;

    @JsonView({View.REST.class})
    @Column(name = "name")
    public String name;

    @JsonView({View.REST.class})
    @Column(name = "patronymic")
    public String patronymic;

    @JsonView({View.REST.class})
    @Column(name = "address")
    public String address;

    @OneToMany(mappedBy = "reader", fetch=FetchType.EAGER)
    @JsonIgnore
    public List<IssuedBook> readers;

    public Reader() {

    }

    public List<IssuedBook> getReaders() {
        return readers;
    }

    public void setReaders(List<IssuedBook> readers) {
        this.readers = readers;
    }

    public Integer getLibraryCard() {
        return libraryCard;
    }

    public void setLibraryCard(Integer libraryCard) {
        this.libraryCard = libraryCard;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
