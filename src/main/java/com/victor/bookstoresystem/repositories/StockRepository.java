package com.victor.bookstoresystem.repositories;

import com.victor.bookstoresystem.entities.StockItem;
import com.victor.bookstoresystem.enums.Category;
import com.victor.bookstoresystem.interfaces.FindItem;

import java.util.ArrayList;
import java.util.List;

public class StockRepository implements FindItem<StockItem> {
    private final List<StockItem> list = new ArrayList<>();

    public List<StockItem> findAll() {
        return list;
    }

    public StockItem findById(int id) {
        return list.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Stock item not found"));
    }

    public List<StockItem> findAllByCategory(Category category) {
        return list.stream()
                .filter(item -> item.getProduct().getCategory().equals(category))
                .toList();
    }

    public void removeById(int id) {
        remove(findById(id));
    }

    public void add(StockItem item) {
        list.add(item);
    }

    public void addAll(List<StockItem> items) {
        list.addAll(items);
    }

    public void clear() {
        list.clear();
    }

    public void remove(StockItem item) {
        list.remove(item);
    }

    public void removeAll(List<StockItem> items) {
        list.removeAll(items);
    }
}
