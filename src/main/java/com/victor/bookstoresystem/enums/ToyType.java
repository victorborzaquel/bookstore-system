package com.victor.bookstoresystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ToyType {
    ACTION_FIGURE("Boneco de Ação"),
    DOLL("Boneca"),
    PUZZLE("Quebra-Cabeça"),
    BOARD_GAME("Jogo de Tabuleiro"),
    CAR("Carro");

    private final String name;
}
