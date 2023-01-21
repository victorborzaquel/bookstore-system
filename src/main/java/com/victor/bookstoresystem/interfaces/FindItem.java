package com.victor.bookstoresystem.interfaces;

import com.victor.bookstoresystem.enums.Category;

import java.util.List;

public interface FindItem<T extends Item> {
    List<T> findAll();
    T findById(int id);
    List<T> findAllByCategory(Category category);
}
