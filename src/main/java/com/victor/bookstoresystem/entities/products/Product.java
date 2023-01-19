package com.victor.bookstoresystem.entities.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
public abstract class Product {
    protected String name;
    protected BigDecimal price;
    protected boolean plus18;

    protected Product(String name) {
        this.name = name;
        this.price = new BigDecimal("0");
        this.plus18 = false;
    }

    protected Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.plus18 = false;
    }
}
