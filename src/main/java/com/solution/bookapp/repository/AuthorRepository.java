package com.solution.bookapp.repository;

import com.solution.bookapp.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByNameAndSurname(String name, String surname);

    @Query(value ="SELECT b.author FROM Book b GROUP BY b.author HAVING COUNT(b)>3")
    List<Author> authorsWithMoreThan3Books();

}
