package com.victor.bookstoresystem.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class OrderItem<T extends Product> {
    private final Integer id;
    private Integer quantity;
    private T product;

    public void increaseQuantity(int value) {
        quantity += value;
    }

    public void decreaseQuantity(int value) {
        quantity -= value;
    }

    public void increaseQuantity() {
        increaseQuantity(1);
    }

    public void decreaseQuantity() {
        decreaseQuantity(1);
    }
}
