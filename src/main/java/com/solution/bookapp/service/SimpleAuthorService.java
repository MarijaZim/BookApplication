package com.solution.bookapp.service;
import com.solution.bookapp.model.Author;
import com.solution.bookapp.model.Book;
import com.solution.bookapp.model.dataHolder.DataHolder;
import org.springframework.stereotype.Service;

@Service
public class SimpleAuthorService {

    public static void authorsIfBornInDecade() {
        boolean exists = false;
        System.out.println("Authors that are born in a decade in which a book was released:");
        for (Author a : DataHolder.authors) {
            int startYear = (a.getYearOfBirth() / 10) * 10;
            int endYear = startYear + 10;
            for (Book b : DataHolder.books) {
                if (b.getYear() >= startYear && b.getYear() <= endYear) {
                    exists = true;
                    System.out.println(a.toString());
                    break;
                }
            }
        }
        if (!exists) {
            System.out.println("No such author.");
        }
    }

    public static void authorsWithMoreThan3Books() {
        int number = 0;
        boolean exists = false;
        System.out.println("Authors with more than 3 books:");
        for (Author a : DataHolder.authors) {
            for (Book b : DataHolder.books) {
                if (b.getAuthor().fullName().compareTo(a.fullName()) == 0) {
                    number++;
                    if (number > 3) {
                        System.out.println(a.toString());
                        exists = true;
                        break;
                    }
                }
            }
            number = 0;
        }
        if (!exists) {
            System.out.println("No such author.");
        }
    }
}
