package com.victor.bookstoresystem.enums.generes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MusicGenere {
    ROCK("Rock"),
    POP("Pop"),
    CLASSICAL("Clássica"),
    ELECTRONIC("Eletrônica"),
    FUNK("Funk");

    private final String name;
}
