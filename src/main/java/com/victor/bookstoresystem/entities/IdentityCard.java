package com.victor.bookstoresystem.entities;

import java.time.LocalDate;

public record IdentityCard(
        String name,
        String Rg,
        String Cpf,
        LocalDate birthDate
) {
}