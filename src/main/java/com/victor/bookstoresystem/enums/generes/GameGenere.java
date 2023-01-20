package com.victor.bookstoresystem.enums.generes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GameGenere {
    RPG("RPG"),
    FPS("FPS"),
    MOBA("MOBA"),
    MMORPG("MMORPG"),
    SIMULATION("Simulação"),
    SPORTS("Esportes");

    private final String name;
}
