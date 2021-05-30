package com.solution.bookapp.model;
import com.solution.bookapp.model.enumeration.BookType;
import lombok.Data;
import javax.persistence.Entity;

@Entity
@Data
public class PrintCopy extends Book {
    private Integer numberOfPages;
    private Double weight;

    public PrintCopy(){
        super();
    }

    public PrintCopy(long isbn,String title,int year, Author author, int numberOfPages, double weight){
        super(isbn,title, year, author);
        this.numberOfPages=numberOfPages;
        this.weight=weight;
    }

    public double getWeight() {
        return weight;
    }

    public int getNumberOfPages() { return numberOfPages; }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    @Override
    public String toString() {
        return super.toString() +
                "numberOfPages: " + numberOfPages +
                ", weight: " + weight +
                '}';
    }
}
