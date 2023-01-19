package com.victor.bookstoresystem;

import com.victor.bookstoresystem.entities.StockItem;
import com.victor.bookstoresystem.entities.products.Product;
import com.victor.bookstoresystem.services.CashRegisterService;
import com.victor.bookstoresystem.repositories.ItemRepository;
import com.victor.bookstoresystem.utils.Initialize;
import com.victor.bookstoresystem.vo.IdentityCard;

import java.math.BigDecimal;
import java.util.Date;

public class BookstoreSystem {
    private static final CashRegister cashRegister = new CashRegister();

    public static void main(String[] args) {
        CashRegisterService.addCash(cashRegister, 1000);

        Initialize.products();

//        List<Item<Product>> all = ItemRepository.findAll();
//        List<Item<Product>> books = ItemRepository.findByCategory(Category.BOOK);

//        int quantity = ItemRepository.getQuantityByCategory(Category.BOOK);

//        ItemRepository.removeById(1);

        ItemRepository itemRepository = new ItemRepository();

        StockItem<Product> p = itemRepository.findById(1);

        IdentityCard identityCard = new IdentityCard("Victor", "123456789", "123456789", new Date(2200, 6, 22));

        BigDecimal troco = cashRegister.sellProduct(p, new BigDecimal("200"), identityCard);

        System.out.println(troco);
//        System.out.println(books);

    }
}
