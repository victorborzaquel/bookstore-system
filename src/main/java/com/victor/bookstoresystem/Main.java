package com.victor.bookstoresystem;

import com.victor.bookstoresystem.entities.CashRegister;
import com.victor.bookstoresystem.entities.StockItem;
import com.victor.bookstoresystem.entities.Order;
import com.victor.bookstoresystem.entities.Product;
import com.victor.bookstoresystem.repositories.DiscountRepository;
import com.victor.bookstoresystem.repositories.StockRepository;
import com.victor.bookstoresystem.utils.Inicialize;

public class Main {
    public static void main(String[] args) {
        DiscountRepository discounts = new DiscountRepository();
        StockRepository stock = new StockRepository();
        StockRepository orderItems = new StockRepository();
        Order order = new Order(orderItems);

        CashRegister cashRegister = new CashRegister();

        Inicialize.products(stock);
        Inicialize.discounts(discounts);

        StockItem<Product> p = stock.findById(1);

        order.save(new StockItem<>(p.getCategory(), 1, p.getProduct()));

        stock.findAll().forEach(System.out::println);
        order.findAll().forEach(System.out::println);

//        OrderService.addItem();

    }
}
