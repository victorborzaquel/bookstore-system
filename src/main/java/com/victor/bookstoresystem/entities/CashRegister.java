package com.victor.bookstoresystem.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CashRegister {
    private Double cash;

    public boolean closeOrder(Purchase purchase) {
        if (purchase.close()) {
            cash -= purchase.getPrice();
            return true;
        }

        return false;
    }
    public void incrementCash(Double value) {
        cash+=value;
    }

    public void decrementCash(Double value) {
        cash-=value;
    }
}
