package com.victor.bookstoresystem.entities;

public interface Item {
    private final Integer id;
    private Integer quantity;
    private T product;



    void increaseQuantity(int value);

    void decreaseQuantity(int value);

    void increaseQuantity();

    void decreaseQuantity();
}
