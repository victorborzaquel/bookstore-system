package com.victor.bookstoresystem.entities.products;

import com.victor.bookstoresystem.enums.Category;
import com.victor.bookstoresystem.enums.generes.GameGenere;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Game extends Product {
    private GameGenere generes;
    private String distributor;
    private String studio;

    public Game(String name, Double price, Integer ageGreaterThan) {
        super(Category.GAME, name, price, ageGreaterThan);
    }

    public Game(String name, Double price, Integer ageGreaterThan, GameGenere generes, String distributor, String studio) {
        super(Category.GAME, name, price, ageGreaterThan);
        this.generes = generes;
        this.distributor = distributor;
        this.studio = studio;
    }
}
