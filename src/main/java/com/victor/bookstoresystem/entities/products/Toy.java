package com.victor.bookstoresystem.entities.products;

import com.victor.bookstoresystem.enums.ToyType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class Toy extends Product {
    private ToyType types;

    public Toy(String name, BigDecimal price) {
        super(name, price);
    }

    public Toy(String name, BigDecimal price, boolean plus18) {
        super(name, price, plus18);
    }

    public Toy(String name, BigDecimal price, ToyType types) {
        super(name, price);
        this.types = types;
    }
}
