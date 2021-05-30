package com.solution.bookapp.model.dataHolder;
import com.solution.bookapp.model.Author;
import com.solution.bookapp.model.Book;
import com.solution.bookapp.model.EBook;
import com.solution.bookapp.model.enumeration.TypeFormat;
import com.solution.bookapp.model.PrintCopy;
import com.solution.bookapp.repository.AuthorRepository;
import com.solution.bookapp.repository.BookRepository;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class DataHolder {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    public static List<Book> books = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();

    public DataHolder(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @PostConstruct
    public void init() {
        Author a1=new Author("Charles","Dickens",1970);
        Author a2=new Author("Joanne","Rowling",1965);
        Author a3=new Author("Jane","Austen",1987);
        Author a4=new Author("Louise","Erdrich",1954);

        Book b1=new PrintCopy(1,"Harry Potter and the Philosopher's Stone",1997,a2,320,0.1);
        Book b2=new PrintCopy(2,"Harry Potter and the Goblet of Fire",1997,a2,180,0.1);
        Book b3=new PrintCopy(3,"The Ickabog",2020,a2,160,0.1);
        Book b4=new PrintCopy(4,"The Silkworm",2014,a2,194,0.1);
        Book b5=new EBook(5,"Pride and Prejudice",1990,a3,TypeFormat.pdf,18.0);
        Book b6=new EBook(6,"Oliver Twist",2000,a1,TypeFormat.epub,28);
        Book b7=new EBook(7,"The Night Watchman",2020,a4,TypeFormat.html5,10);

        authors.addAll(List.of(a1,a2,a3,a4));
        books.addAll(List.of(b1,b2,b3,b4,b5,b6,b7));

        authorRepository.saveAll(authors);
        bookRepository.saveAll(books);


    }

}
