package com.victor.bookstoresystem;

import com.victor.bookstoresystem.entities.StockItem;
import com.victor.bookstoresystem.entities.products.Product;
import com.victor.bookstoresystem.repositories.ItemRepository;
import com.victor.bookstoresystem.vo.IdentityCard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Calendar;

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

    public BigDecimal sellProduct(StockItem<Product> stockItem, BigDecimal cash) {
        Product product = stockItem.getProduct();
        BigDecimal price = product.getPrice();

        if (product.isPlus18()) {
            throw new IllegalArgumentException("Esse produto é para maiores de 18 anos");
        }

        if (price.subtract(cash).doubleValue() > 0 ) {
            throw new IllegalArgumentException("Dinheiro insuficiente");
        }

        this.cash = this.cash.add(price);
        ItemRepository.subtractProduct(stockItem);

        return cash.subtract(price);
    }

    public BigDecimal sellProduct(StockItem<Product> stockItem, BigDecimal cash, IdentityCard identityCard) {
        Product product = stockItem.getProduct();
        BigDecimal price = product.getPrice();

        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int birthYear = identityCard.birthDate().getYear();

        int age = year - birthYear;

        if (product.isPlus18() && age < 18) {
            throw new IllegalArgumentException("Esse produto é para maiores de 18 anos");
        }

        if (price.subtract(cash).doubleValue() > 0 ) {
            throw new IllegalArgumentException("Dinheiro insuficiente");
        }

        this.cash = this.cash.add(price);
        ItemRepository.subtractProduct(stockItem);

        return cash.subtract(price);
    }
}
