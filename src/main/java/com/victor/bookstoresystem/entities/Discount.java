package com.victor.bookstoresystem.entities;

import com.victor.bookstoresystem.enums.Category;

public interface Discount {
    Double apply(Category category, double price);
}
