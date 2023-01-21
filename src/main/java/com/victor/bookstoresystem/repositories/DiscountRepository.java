package com.victor.bookstoresystem.repositories;

import com.victor.bookstoresystem.entities.Discount;
import com.victor.bookstoresystem.interfaces.FindDiscount;

import java.util.ArrayList;
import java.util.List;

public class DiscountRepository implements FindDiscount {
    private final List<Discount> discounts = new ArrayList<>();

    public List<Discount> findAll() {
        return discounts;
    }

    public void add(Discount item) {
        discounts.add(item);
    }

    public void addAll(List<Discount> items) {
        discounts.addAll(items);
    }

    public void clear() {
        discounts.clear();
    }

    public void remove(Discount item) {
        discounts.remove(item);
    }

    public void removeAll(List<Discount> items) {
        discounts.removeAll(items);
    }
}
