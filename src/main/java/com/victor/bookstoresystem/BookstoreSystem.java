package com.victor.bookstoresystem;

import com.victor.bookstoresystem.entities.CashRegister;
import com.victor.bookstoresystem.entities.Item;
import com.victor.bookstoresystem.entities.products.Product;
import com.victor.bookstoresystem.enums.Category;
import com.victor.bookstoresystem.repositories.CashRegisterRepository;
import com.victor.bookstoresystem.repositories.ItemRepository;
import com.victor.bookstoresystem.utils.Initialize;

import java.math.BigDecimal;
import java.util.List;

public class BookstoreSystem {
    private static final CashRegister cashRegister = new CashRegister();

    public static void main(String[] args) {
        CashRegisterRepository.addCash(cashRegister, 1000);

        Initialize.products();

        List<Item<Product>> all = ItemRepository.findAll();
        List<Item<Product>> books = ItemRepository.findByCategory(Category.BOOK);

        int quantity = ItemRepository.getQuantityByCategory(Category.BOOK);

        ItemRepository.removeById(1);

        Item<Product> p2 = ItemRepository.findById(2);

        BigDecimal troco = cashRegister.sellProduct(p2, new BigDecimal("200"));

        System.out.println(troco);
//        System.out.println(books);

    }
}
