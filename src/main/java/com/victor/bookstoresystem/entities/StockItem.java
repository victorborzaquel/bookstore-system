package com.victor.bookstoresystem.entities;

import com.victor.bookstoresystem.entities.products.Product;
import com.victor.bookstoresystem.enums.Category;
import com.victor.bookstoresystem.utils.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class StockItem<T extends Product> {
    private final Integer id = Id.generate();
    private Category category;
    private T product;
    private int quantity;
}
