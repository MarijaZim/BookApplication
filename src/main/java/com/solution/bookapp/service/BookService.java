package com.solution.bookapp.service;
import com.solution.bookapp.model.Author;
import com.solution.bookapp.model.Book;
import com.solution.bookapp.model.EBook;
import com.solution.bookapp.model.PrintCopy;
import com.solution.bookapp.model.exceptions.BookNotFoundException;
import com.solution.bookapp.repository.AuthorRepository;
import com.solution.bookapp.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Optional<Book> findByIsbn(long isbn){
        return this.bookRepository.findById(isbn);
    }

    public List<Book> findAllBooks(){
        return this.bookRepository.findAll();
    }

    public List<Book> chronologicalBooks(){
        List<Book> books=this.bookRepository.findAll();
        Collections.sort(books);
        return books;
    }

    public List<Book> booksByAuthorWithSurnameLetter(char c){
        List<Book> books=this.bookRepository.getBooksByAuthorsWithFirstLetter(c);
        return books;
    }

    public List<Book> findOldestAndNewestBooks(){
        List<Book> oldestAndNewestBook=new ArrayList<>();
        oldestAndNewestBook.add(this.bookRepository.findTopByOrderByYearAsc());
        oldestAndNewestBook.add(this.bookRepository.findTopByOrderByYearDesc());
        return oldestAndNewestBook;
    }

    public Optional<Book> save(Book book){
        Author author=this.authorRepository.findByNameAndSurname(book.getAuthor().getName(),book.getAuthor().getSurname());
        if(author == null){
            author=this.authorRepository.save(book.getAuthor());
        }


        boolean isEbook = book instanceof EBook;
        if(isEbook)
        {
            EBook ebook=(EBook) book;
            ebook.setAuthor(author);
            return Optional.of(bookRepository.save(ebook));
        }
        else {
            PrintCopy printCopy=(PrintCopy) book;
            printCopy.setAuthor(author);
            return Optional.of(bookRepository.save(printCopy));
        }
    }

    public Optional<Book> edit(long isbn, Book book) {
        Book oldBook=this.bookRepository.findById(isbn).orElseThrow(() -> new BookNotFoundException(isbn));
        Author author=this.authorRepository.findByNameAndSurname(book.getAuthor().getName(),book.getAuthor().getSurname());
        if(author == null){
            author=this.authorRepository.save(book.getAuthor());
        }

        boolean isEbook = oldBook instanceof EBook;
        if(isEbook)
        {
            EBook editedEBook=(EBook) book;
            editedEBook.setAuthor(author);
            this.bookRepository.deleteById(oldBook.getIsbn());
            return Optional.of(this.bookRepository.save(editedEBook));

        }
        else {
            PrintCopy editedPrintBook=(PrintCopy) book;
            editedPrintBook.setAuthor(author);
            this.bookRepository.deleteById(oldBook.getIsbn());
            return Optional.of(this.bookRepository.save(editedPrintBook));
        }
    }

    public  void deleteByIsbn(long isbn){
        bookRepository.deleteById(isbn);
    }

}
