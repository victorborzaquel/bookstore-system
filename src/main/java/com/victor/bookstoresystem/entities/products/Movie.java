package com.victor.bookstoresystem.entities.products;

import com.victor.bookstoresystem.enums.MovieAndBookGenere;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
public class Movie extends Product {
    private List<MovieAndBookGenere> generes;
    private String studio;
    private List<String> directors;
    private List<String> producers;

    public Movie(String name, BigDecimal price) {
        super(name, price);
    }

    public Movie(String name, BigDecimal price, List<MovieAndBookGenere> generes, String studio, List<String> directors, List<String> producers) {
        super(name, price);
        this.generes = generes;
        this.studio = studio;
        this.directors = directors;
        this.producers = producers;
    }
}
