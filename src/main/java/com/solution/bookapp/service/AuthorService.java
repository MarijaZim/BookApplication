package com.solution.bookapp.service;
import com.solution.bookapp.model.Author;
import com.solution.bookapp.model.Book;
import com.solution.bookapp.model.exceptions.AuthorNotFoundException;
import com.solution.bookapp.repository.AuthorRepository;
import com.solution.bookapp.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author findById(long id){
        Author author=this.authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
        return author;
    }

    public  List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }


    public List<Author> authorsIfBornInDecade() {
        List<Author> authors=new ArrayList<>();
        for (Author a : this.authorRepository.findAll()) {
            int startYear = (a.getYearOfBirth() / 10) * 10;
            int endYear = startYear + 10;
            for (Book b : this.bookRepository.findAll()) {
                if (b.getYear() >= startYear && b.getYear() <= endYear) {
                    authors.add(a);
                    break;
                }
            }
        }
        return authors;
    }

    public List<Author> authorsWithMoreThan3Books() {
        List<Author> authors=this.authorRepository.authorsWithMoreThan3Books();
        return authors;
    }
}
