package com.solution.bookapp.controller;
import com.solution.bookapp.service.AuthorService;
import com.solution.bookapp.model.Author;
import com.solution.bookapp.model.Book;
import com.solution.bookapp.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    BookController(BookService bookService, AuthorService authorService){
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/books")
    private List<Book> findAllBooks() {
        return this.bookService.findAllBooks();
    }

    @GetMapping("/authors")
    private List<Author> findAllAuthors(){
        return this.authorService.findAllAuthors();
    }

    @GetMapping("/books/{isbn}")
    public ResponseEntity<Book> findByIsbn(@PathVariable int isbn) {
        return this.bookService.findByIsbn(isbn)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/books/add")
    public ResponseEntity<Book> save(@RequestBody Book book) {
        return this.bookService.save(book)
                .map(newBook -> ResponseEntity.status(HttpStatus.CREATED).body(newBook))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/books/edit/{isbn}")
    public ResponseEntity<Book> save(@PathVariable long isbn, @RequestBody Book book) {
        return this.bookService.edit(isbn,book)
                .map(newBook -> ResponseEntity.ok().body(newBook))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("books/delete/{isbn}")
    public ResponseEntity deleteById(@PathVariable int isbn) {
        this.bookService.deleteByIsbn(isbn);
        if(this.bookService.findByIsbn(isbn).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

}
