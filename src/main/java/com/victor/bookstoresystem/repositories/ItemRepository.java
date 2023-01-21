package com.victor.bookstoresystem.repositories;

import com.victor.bookstoresystem.interfaces.FindItem;
import com.victor.bookstoresystem.interfaces.Item;
import com.victor.bookstoresystem.enums.Category;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository<T extends Item> implements FindItem<T> {
    private final List<T> list = new ArrayList<>();

    public List<T> findAll() {
        return list;
    }

    public T findById(int id) {
        return list.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Stock item not found"));
    }

    public List<T> findAllByCategory(Category category) {
        return list.stream()
                .filter(item -> item.getProduct().getCategory().equals(category))
                .toList();
    }

    public void removeById(int id) {
        remove(findById(id));
    }

    public void add(T item) {
        list.add(item);
    }

    public void addAll(List<T> items) {
        list.addAll(items);
    }

    public void clear() {
        list.clear();
    }

    public void remove(T item) {
        list.remove(item);
    }

    public void removeAll(List<T> items) {
        list.removeAll(items);
    }
}
