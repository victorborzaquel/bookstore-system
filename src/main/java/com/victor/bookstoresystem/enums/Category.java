package com.victor.bookstoresystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    BOOK("Livro"),
    GAME("Jogo"),
    MUSIC_ALBUM("Album de Música"),
    MOVIE("Filme"),
    TOY("Brinquedo");

    private final String name;
}
