package com.victor.bookstoresystem.entities;

import com.victor.bookstoresystem.interfaces.FindDiscount;
import com.victor.bookstoresystem.services.OrderService;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CashRegister {
    private double cash;
    private final FindDiscount discounts;

    public void sell(OrderService order) {
        final double discount = order.calculateDiscount(discounts);
        final double total = order.calculateTotalPrice();

        cash += Math.max(0, total - discount);
        order.clear();
    }
}
