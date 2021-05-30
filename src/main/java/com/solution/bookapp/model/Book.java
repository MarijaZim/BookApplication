package com.solution.bookapp.model;
import com.fasterxml.jackson.annotation.*;
import com.solution.bookapp.model.enumeration.BookType;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "bookType", visible = false)
@JsonSubTypes({
        @JsonSubTypes.Type(value = EBook.class, name = "EBook"),
        @JsonSubTypes.Type(value = PrintCopy.class, name = "PrintCopy")
})
public abstract class Book implements Comparable<Book>{

    @Id
    private Long isbn;
    private String title;
    private Integer year;

    @ManyToOne
    private Author author;

    public Book(){}

    public Book(long isbn, String title, int year, Author author){
        this.title=title;
        this.isbn=isbn;
        this.year=year;
        this.author=author;
    }

    public int getYear() {
        return year;
    }

    public Author getAuthor() {
        return author;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setYear(Integer year) { this.year = year; }

    @Override
    public int compareTo(Book b) {
        if(getYear()>=b.getYear()){
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title: " + title +
                ", isbn:" + isbn +
                ", year: "+ year +
                ", author: " + author.getName() +" "+author.getSurname()+", ";
    }
}
