package com.victor.bookstoresystem.entities.products;

import com.victor.bookstoresystem.enums.GameGenere;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class Game extends Product {
    private GameGenere generes;
    private String distributor;
    private String studio;

    public Game(String name, BigDecimal price) {
        super(name, price);
    }

    public Game(String name, BigDecimal price, boolean plus18) {
        super(name, price, plus18);
    }

    public Game(String name, BigDecimal price, GameGenere generes, String distributor, String studio) {
        super(name, price);
        this.generes = generes;
        this.distributor = distributor;
        this.studio = studio;
    }
}
