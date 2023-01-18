package com.victor.bookstoresystem.enums;

public enum ProductType {
    MUSIC_ALBUMS("Álbum de Música"),
    GAME("Jogo"),
    TOY("Brinquedo"),
    BOOK("Livro"),
    MOVIE("Filme");

    private final String name;

    ProductType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
