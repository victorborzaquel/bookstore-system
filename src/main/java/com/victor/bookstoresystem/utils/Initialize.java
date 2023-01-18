package com.victor.bookstoresystem.utils;

import com.victor.bookstoresystem.entities.Item;
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
        Game game2 = new Game("God of War 2", new BigDecimal("200"));
        Game game3 = new Game("God of War 3", new BigDecimal("200"));

        Movie movie1 = new Movie("Harry Potter", new BigDecimal("100"));
        Movie movie2 = new Movie("Harry Potter 2", new BigDecimal("100"));
        Movie movie3 = new Movie("Harry Potter 3", new BigDecimal("100"));

        MusicAlbum musicAlbum1 = new MusicAlbum("Harry Potter", new BigDecimal("100"));
        MusicAlbum musicAlbum2 = new MusicAlbum("Harry Potter 2", new BigDecimal("100"));
        MusicAlbum musicAlbum3 = new MusicAlbum("Harry Potter 3", new BigDecimal("100"));

        Toy toy1 = new Toy("Harry Potter", new BigDecimal("100"));
        Toy toy2 = new Toy("Harry Potter 2", new BigDecimal("100"));
        Toy toy3 = new Toy("Harry Potter 3", new BigDecimal("100"));

        ItemRepository.addAll(List.of(
                new Item<>(book1, Category.BOOK),
                new Item<>(book2, Category.BOOK),
                new Item<>(book3, Category.BOOK),
                new Item<>(book4, Category.BOOK),
                new Item<>(game1, Category.GAME),
                new Item<>(game2, Category.GAME),
                new Item<>(game3, Category.GAME),
                new Item<>(movie1, Category.MOVIE),
                new Item<>(movie2, Category.MOVIE),
                new Item<>(movie3, Category.MOVIE),
                new Item<>(musicAlbum1, Category.MUSIC_ALBUM),
                new Item<>(musicAlbum2, Category.MUSIC_ALBUM),
                new Item<>(musicAlbum3, Category.MUSIC_ALBUM),
                new Item<>(toy1, Category.TOY),
                new Item<>(toy2, Category.TOY),
                new Item<>(toy3, Category.TOY)
        ));
    }
}
