package com.victor.bookstoresystem.entities;

import com.victor.bookstoresystem.enums.Category;

public interface Discount {
    Double aplicar(Category category, Double price);
}
