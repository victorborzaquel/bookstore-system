package com.victor.bookstoresystem.entities.products;

import com.victor.bookstoresystem.enums.Category;
import com.victor.bookstoresystem.enums.generes.BookGenere;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Book extends Product {
    private List<BookGenere> generes;
    private String writer;
    private String publisher;

    public Book(String name, Double price, Integer ageGreaterThan) {
        super(Category.BOOK, name, price, ageGreaterThan);
    }

    public Book(String name, Double price, Integer ageGreaterThan, List<BookGenere> generes, String writer, String publisher) {
        super(Category.BOOK, name, price, ageGreaterThan);
        this.generes = generes;
        this.writer = writer;
        this.publisher = publisher;
    }
}
