package com.victor.bookstoresystem.entities;

import com.victor.bookstoresystem.entities.products.Product;
import com.victor.bookstoresystem.enums.IdType;
import com.victor.bookstoresystem.utils.Id;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class StockItem implements Item{
    private final Integer id = Id.generate(IdType.ITEM);
    private int quantity;
    private Product product;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
