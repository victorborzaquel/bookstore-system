package com.victor.bookstoresystem.entities;

import com.victor.bookstoresystem.entities.products.Product;
import com.victor.bookstoresystem.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class CashRegister {
    private BigDecimal cash;

    public CashRegister() {
        this.cash = new BigDecimal("0");
    }

    public void incrementCash(BigDecimal cash) {
        this.cash = this.cash.add(cash);
    }

    public void decrementCash(BigDecimal cash) {
        this.cash = this.cash.subtract(cash);
    }

    public BigDecimal sellProduct(Item<Product> item, BigDecimal cash) {
        BigDecimal price = item.getProduct().getPrice();
        if (price.subtract(cash).doubleValue() > 0 ) {
            throw new IllegalArgumentException("Dinheiro insuficiente");
        }

        this.cash = this.cash.add(price);
        ItemRepository.subtractProduct(item);

        return cash.subtract(price);
    }
}
