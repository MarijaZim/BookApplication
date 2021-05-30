package com.solution.bookapp.model;
import com.solution.bookapp.model.enumeration.BookType;
import com.solution.bookapp.model.enumeration.TypeFormat;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
public class EBook extends Book{

    @Enumerated(EnumType.STRING)
    private TypeFormat format;
    private Double size;

    public EBook(){
        super();
    }

    public EBook(long isbn,String title,int year, Author author, TypeFormat format, double size){
        super(isbn,title, year, author);
        this.format=format;
        this.size=size;
    }

    public double getSize() {
        return size;
    }

    public TypeFormat getFormat() {
        return format;
    }

    public void setFormat(TypeFormat format) {
        this.format = format;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString()+
                "format: " + format +
                ", size: " + size +
                '}';
    }
}
