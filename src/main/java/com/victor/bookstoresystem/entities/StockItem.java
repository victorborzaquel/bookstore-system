package com.victor.bookstoresystem.entities;

import com.victor.bookstoresystem.enums.IdType;
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
    private final Integer id = Id.generate(IdType.ITEM);
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
