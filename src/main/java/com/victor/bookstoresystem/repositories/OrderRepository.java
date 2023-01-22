package com.victor.bookstoresystem.repositories;

import com.victor.bookstoresystem.entities.OrderItem;
import com.victor.bookstoresystem.enums.Category;
import com.victor.bookstoresystem.interfaces.FindItem;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements FindItem<OrderItem> {
    private final List<OrderItem> list = new ArrayList<>();

    public List<OrderItem> findAll() {
        return list;
    }

    public OrderItem findById(int id) {
        return list.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Stock item not found"));
    }

    public List<OrderItem> findAllByCategory(Category category) {
        return list.stream()
                .filter(item -> item.getProduct().getCategory().equals(category))
                .toList();
    }

    public void removeById(int id) {
        remove(findById(id));
    }

    public void add(OrderItem item) {
        list.add(item);
    }

    public void addAll(List<OrderItem> items) {
        list.addAll(items);
    }

    public void clear() {
        list.clear();
    }

    public void remove(OrderItem item) {
        list.remove(item);
    }

    public void removeAll(List<OrderItem> items) {
        list.removeAll(items);
    }
}
