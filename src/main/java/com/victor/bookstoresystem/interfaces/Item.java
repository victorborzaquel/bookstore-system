package com.victor.bookstoresystem.interfaces;

import com.victor.bookstoresystem.entities.products.Product;

public interface Item {
    int getId();
    int getQuantity();
    void setQuantity(int quantity);
    Product getProduct();
}
