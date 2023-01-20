package com.victor.bookstoresystem.services;

import com.victor.bookstoresystem.entities.IdentityCard;
import com.victor.bookstoresystem.entities.StockItem;
import com.victor.bookstoresystem.entities.Order;
import com.victor.bookstoresystem.entities.Product;
import com.victor.bookstoresystem.repositories.StockRepository;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@AllArgsConstructor
public class OrderService {
    StockRepository stock;
    Order order;
    IdentityCard identityCard;

    public boolean addProduct(Integer id, Integer quantity) {
        StockItem<Product> stockItem = stock.findById(id);
        long age = identityCard.birthDate().until(LocalDate.now(), ChronoUnit.YEARS);

        if (age < stockItem.getProduct().getAgeGreaterThan()) {
            return false;
        }

        order.getItems().save(new StockItem<>(quantity, stockItem.getProduct()));
        stockItem.decreaseQuantity(quantity);
        return true;
    }

    public boolean addProduct(Integer id) {
        return addProduct(id, 1);
    }

    public boolean removeProduct(Integer id, Integer quantity) {
        StockItem<Product> stockItem = order.getItems().findById(id);

        stockItem.decreaseQuantity(quantity);
        stock.findById(id);
        return true;
    }

    public boolean removeProduct(Integer id) {
        return addProduct(id, 1);
    }
}
