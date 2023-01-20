package com.victor.bookstoresystem.entities.products;

import com.victor.bookstoresystem.entities.Product;
import com.victor.bookstoresystem.enums.Category;
import com.victor.bookstoresystem.enums.generes.ToyType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Toy extends Product {
    private ToyType types;

    public Toy(String name, Double price, Integer ageGreaterThan) {
        super(Category.TOY, name, price, ageGreaterThan);
    }

    public Toy(String name, Double price, Integer ageGreaterThan, ToyType types) {
        super(Category.TOY, name, price, ageGreaterThan);
        this.types = types;
    }
}
