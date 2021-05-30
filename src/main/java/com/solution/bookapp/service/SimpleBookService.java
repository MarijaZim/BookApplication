package com.solution.bookapp.service;
import com.solution.bookapp.model.Book;
import com.solution.bookapp.model.dataHolder.DataHolder;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SimpleBookService {

    public static void chronologicalBooks(){
        Collections.sort(DataHolder.books);
        System.out.println("Books sorted by year:");
        for(int i=0;i<DataHolder.books.size();i++){
            System.out.println(DataHolder.books.get(i).toString());
        }
    }

    public static void booksByAuthorWithSurnameLetter(char c){
        boolean exists=false;
        System.out.println("Books by authors that have surname starting with the letter "+c);
        for (Book b: DataHolder.books) {
            if(b.getAuthor().getSurname().toUpperCase().startsWith(String.valueOf(Character.toUpperCase(c)))){
                exists=true;
                System.out.println(b.toString());
            }
        }
        if(!exists){System.out.println("No such books.");}
    }
    public static void findOldestAndNewestBooks(){
        Book oldest=DataHolder.books.get(0);
        Book newest=DataHolder.books.get(DataHolder.books.size()-1);
        System.out.println("Thes oldest book is: "+ oldest.toString());
        System.out.println("The newest book is: "+newest.toString());
    }

//    public static Optional<Book> save(Book book){
//        Author author = SimpleAuthorService.findByFullName(book.getAuthor().fullName());
//
//        deleteByIsbn(book.getIsbn());
//        Book newBook = new EBook(book.getIsbn(),book.getTitle(),book.getYear(),book.getAuthor(), TypeFormat.pdf,194);
//        DataHolder.books.add(newBook);
//        return Optional.of(newBook);
//    }
//
//    public Optional<Book> edit(int isbn, Book book) {
//        Book newBook= findByIsbn(isbn).orElse(null);
//        newBook.setTitle(book.getTitle());
//        Author author = SimpleAuthorService.findByFullName(book.getAuthor().fullName());
//        newBook.setAuthor(author);
//        save(book);
//        return Optional.of(newBook);
//
//    }
//    public static void deleteByIsbn(long isbn){
//        Iterator<Book> books = DataHolder.books.iterator();
//        while (books.hasNext()) {
//            Book b = books.next();
//            if (b.getIsbn() == isbn) {
//                books.remove();
//                break;
//            }
//        }
//    }
}
