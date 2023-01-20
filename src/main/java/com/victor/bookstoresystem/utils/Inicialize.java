package com.victor.bookstoresystem.utils;

import com.victor.bookstoresystem.entities.Discount;
import com.victor.bookstoresystem.entities.StockItem;
import com.victor.bookstoresystem.entities.Product;
import com.victor.bookstoresystem.entities.products.*;
import com.victor.bookstoresystem.enums.Category;
import com.victor.bookstoresystem.repositories.DiscountRepository;
import com.victor.bookstoresystem.repositories.StockRepository;

import java.util.Arrays;
import java.util.List;

public class Inicialize {
    private Inicialize() {}

    public static void products(StockRepository stockRepository) {
        List<StockItem<Product>> products = Arrays.asList(
                new StockItem<>(10, new Book("Harry Potter", 10.0, 10)),
                new StockItem<>(20, new Book("Senhor dos Aneis", 20.0, 20)),
                new StockItem<>(14, new Movie("Fuga", 10.0, 10)),
                new StockItem<>(12, new Game("LOL", 10.0, 18)),
                new StockItem<>(13, new MusicAlbum("Banda", 10.0, 18)),
                new StockItem<>(51, new Toy("Boneco", 10.0, 10))
        );

        stockRepository.saveAll(products);
    }

    public static void discounts(DiscountRepository discountRepository) {
        List<Discount> discounts = Arrays.asList(
                (category, price) -> (category == Category.BOOK && price > 200D) ? price * 0.85 : 0.0
        );

        discountRepository.saveAll(discounts);
    }


}
