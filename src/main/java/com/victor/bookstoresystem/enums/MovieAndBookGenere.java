package com.victor.bookstoresystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MovieAndBookGenere {
    ACTION("Ação"),
    ADVENTURE("Aventura"),
    COMEDY("Comédia"),
    DRAMA("Drama"),
    FANTASY("Fantasia"),
    HORROR("Terror");

    private final String name;
}
