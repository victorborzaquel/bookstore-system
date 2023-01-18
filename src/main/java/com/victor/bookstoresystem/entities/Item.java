package com.victor.bookstoresystem.entities;

import com.victor.bookstoresystem.entities.products.Product;
import com.victor.bookstoresystem.enums.Category;
import com.victor.bookstoresystem.utils.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Item<T extends Product> {
    private final Integer id = Id.generate();
    private Category category;
    private T product;
    private int quantity;

    public Item(T product, Category category) {
        this.product = product;
        this.category = category;
        this.quantity = 1;
    }

    public Item(T product, Category category, int quantity) {
        this.product = product;
        this.category = category;
        this.quantity = quantity;
    }
}
