package com.solution.bookapp.repository;
import com.solution.bookapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query(value = "SELECT b FROM Book b WHERE b.author.surname LIKE :c%")
    List<Book> getBooksByAuthorsWithFirstLetter(char c);
    Book findTopByOrderByYearAsc();
    Book findTopByOrderByYearDesc();
}
