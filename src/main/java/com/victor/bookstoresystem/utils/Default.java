package com.victor.bookstoresystem.utils;

import com.victor.bookstoresystem.entities.Discount;
import com.victor.bookstoresystem.entities.IdentityCard;
import com.victor.bookstoresystem.entities.OrderItem;
import com.victor.bookstoresystem.entities.StockItem;
import com.victor.bookstoresystem.entities.products.*;
import com.victor.bookstoresystem.enums.Category;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Default {
    private Default() {}

    public static List<StockItem> stock() {
        return Arrays.asList(
                new StockItem(10, new Book("Harry Potter", 10.0, 10)),
                new StockItem(20, new Book("Senhor dos Aneis", 20.0, 20)),
                new StockItem(14, new Movie("Fuga", 10.0, 10)),
                new StockItem(12, new Game("LOL", 10.0, 18)),
                new StockItem(13, new MusicAlbum("Banda", 10.0, 18)),
                new StockItem(51, new Toy("Boneco", 10.0, 10))
        );
    }

    public static List<Discount> discounts() {
        return Arrays.asList(
                (category, price) -> (category == Category.BOOK && price > 200D) ? price * 0.85 : 0.0
        );
    }

    public static IdentityCard identityCard() {
        return new IdentityCard("Victor", "123456789", "123456789", LocalDate.of(2000, 1, 1));
    }

    public static List<OrderItem> order() {
        return new ArrayList<>();
    }
}
