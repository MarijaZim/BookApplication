package com.solution.bookapp.model.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AuthorNotFoundException extends RuntimeException{

    public AuthorNotFoundException(Long id) {
        super(String.format("Author with id: %d was not found", id));
    }

    public AuthorNotFoundException(String name, String surname) {
        super(String.format("Author with name: %s %s was not found", name, surname));
    }

}
