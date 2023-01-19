package com.victor.bookstoresystem.utils;

import com.victor.bookstoresystem.entities.StockItem;
import com.victor.bookstoresystem.entities.products.*;
import com.victor.bookstoresystem.enums.Category;
import com.victor.bookstoresystem.repositories.ItemRepository;

import java.math.BigDecimal;
import java.util.List;

public class Initialize {

    private Initialize() {}

    public static void products() {
        Book book1 = new Book("Harry Potter", new BigDecimal("100"), true);
        Book book2 = new Book("Harry Potter 2", new BigDecimal("100"));
        Book book3 = new Book("Harry Potter 3", new BigDecimal("100"));
        Book book4 = new Book("Harry Potter 4", new BigDecimal("100"));

        Game game1 = new Game("God of War", new BigDecimal("200"));
        Game game2 = new Game("God of War 2", new BigDecimal("200"), true);
        Game game3 = new Game("God of War 3", new BigDecimal("200"));

        Movie movie1 = new Movie("Harry Potter", new BigDecimal("100"));
        Movie movie2 = new Movie("Harry Potter 2", new BigDecimal("100"));
        Movie movie3 = new Movie("Harry Potter 3", new BigDecimal("100"));

        MusicAlbum musicAlbum1 = new MusicAlbum("Harry Potter", new BigDecimal("100"));
        MusicAlbum musicAlbum2 = new MusicAlbum("Harry Potter 2", new BigDecimal("100"));
        MusicAlbum musicAlbum3 = new MusicAlbum("Harry Potter 3", new BigDecimal("100"));

        Toy toy1 = new Toy("Harry Potter", new BigDecimal("100"), true);
        Toy toy2 = new Toy("Harry Potter 2", new BigDecimal("100"));
        Toy toy3 = new Toy("Harry Potter 3", new BigDecimal("100"));

        ItemRepository.addAll(List.of(
                new StockItem<>(Category.BOOK, book1, 12),
                new StockItem<>(Category.BOOK, book2, 5),
                new StockItem<>(Category.BOOK, book3, 6),
                new StockItem<>(Category.BOOK, book4, 9),
                new StockItem<>(Category.GAME, game1, 13),
                new StockItem<>(Category.GAME, game2, 11),
                new StockItem<>(Category.GAME, game3, 3),
                new StockItem<>(Category.MOVIE, movie1, 2),
                new StockItem<>(Category.MOVIE, movie2, 1),
                new StockItem<>(Category.MOVIE, movie3, 4),
                new StockItem<>(Category.MUSIC_ALBUM, musicAlbum1, 7),
                new StockItem<>(Category.MUSIC_ALBUM, musicAlbum2, 8),
                new StockItem<>(Category.MUSIC_ALBUM, musicAlbum3, 10),
                new StockItem<>(Category.TOY, toy1, 15),
                new StockItem<>(Category.TOY, toy2, 14),
                new StockItem<>(Category.TOY, toy3, 16)
        ));
    }
}
