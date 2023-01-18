package com.victor.bookstoresystem.entities.products;

import com.victor.bookstoresystem.enums.MovieAndBookGenere;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
public class Book extends Product {
    private List<MovieAndBookGenere> generes;
    private String writer;
    private String publisher;

    public Book(String name) {
        super(name);
    }

    public Book(String name, BigDecimal price) {
        super(name, price);
    }

    public Book(String name, BigDecimal price, List<MovieAndBookGenere> generes, String writer, String publisher) {
        super(name, price);
        this.generes = generes;
        this.writer = writer;
        this.publisher = publisher;
    }
}