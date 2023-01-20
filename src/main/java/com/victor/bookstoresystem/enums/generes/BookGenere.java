package com.victor.bookstoresystem.enums.generes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BookGenere {
    ACTION("Ação"),
    ADVENTURE("Aventura"),
    COMEDY("Comédia"),
    DRAMA("Drama"),
    FANTASY("Fantasia"),
    HORROR("Terror");

    private final String name;
}
