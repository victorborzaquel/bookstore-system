package com.victor.bookstoresystem.entities;

import com.victor.bookstoresystem.entities.products.Product;
import com.victor.bookstoresystem.interfaces.Item;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class OrderItem implements Item {
    private final int id;
    private int quantity;
    private final Product product;

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
