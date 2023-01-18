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

    protected Product(String name) {
        this.name = name;
        this.price = new BigDecimal("0");
    }
}
