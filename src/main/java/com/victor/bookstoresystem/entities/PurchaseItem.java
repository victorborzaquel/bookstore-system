package com.victor.bookstoresystem.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PurchaseItem {
    private final Integer id;
    private int quantity;
}
