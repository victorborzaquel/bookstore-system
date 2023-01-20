package com.victor.bookstoresystem.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public record IdentityCard(
        String name,
        String Rg,
        String Cpf,
        LocalDate birthDate
) {
    public int getAge() {
        return (int) ChronoUnit.YEARS.between(birthDate, LocalDateTime.now());
    }
}