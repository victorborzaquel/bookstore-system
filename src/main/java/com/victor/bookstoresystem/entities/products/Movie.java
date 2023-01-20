package com.victor.bookstoresystem.entities.products;

import com.victor.bookstoresystem.enums.Category;
import com.victor.bookstoresystem.enums.generes.MovieGenere;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Movie extends Product {
    private List<MovieGenere> generes;
    private String studio;
    private List<String> directors;
    private List<String> producers;

    public Movie(String name, Double price, Integer ageGreaterThan) {
        super(Category.MOVIE, name, price, ageGreaterThan);
    }

    public Movie(String name, Double price, Integer ageGreaterThan, List<MovieGenere> generes, String studio, List<String> directors, List<String> producers) {
        super(Category.MOVIE, name, price, ageGreaterThan);
        this.generes = generes;
        this.studio = studio;
        this.directors = directors;
        this.producers = producers;
    }
}
