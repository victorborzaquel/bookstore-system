package com.victor.bookstoresystem.vo;

import java.util.Date;

//Nome, RG, CPF e Data de Nascimento)
public record IdentityCard(
        String name,
        String Rg,
        String cpf,
        Date birthDate
) {}
