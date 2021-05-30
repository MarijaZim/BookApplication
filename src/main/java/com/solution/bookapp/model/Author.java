package com.solution.bookapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private int yearOfBirth;

    public Author(){}

    public Author(String name, String surname, int yearOfBirth){
        this.name=name;
        this.surname=surname;
        this.yearOfBirth=yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public Long getId() { return id; }


    public String getSurname() {
        return surname;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String fullName(){
        return name+" "+surname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}
