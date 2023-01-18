package com.victor.bookstoresystem.entities.products;

import com.victor.bookstoresystem.enums.ToyType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class Toy extends Product {
    private ToyType types;

    public Toy(String name, BigDecimal price) {
        super(name, price);
    }

    public Toy(String name, BigDecimal price, ToyType types) {
        super(name, price);
        this.types = types;
    }
}
