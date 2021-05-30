package com.solution.bookapp;
import com.solution.bookapp.service.SimpleAuthorService;
import com.solution.bookapp.service.SimpleBookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BookappApplication {

    public static void main(String[] args) {

        SpringApplication.run(BookappApplication.class, args);

        SimpleBookService.chronologicalBooks();

        SimpleBookService.booksByAuthorWithSurnameLetter('E');

        SimpleAuthorService.authorsIfBornInDecade();

        SimpleAuthorService.authorsWithMoreThan3Books();

        SimpleBookService.findOldestAndNewestBooks();
    }

}
