package com.victor.bookstoresystem.repositories;

import com.victor.bookstoresystem.entities.Discount;

import java.util.LinkedList;
import java.util.List;

public class DiscountRepository {
    private final List<Discount> discounts = new LinkedList<>();

    public List<Discount> findAll() {
        return discounts;
    }

    public void save(Discount item) {
        discounts.add(item);
    }

    public void saveAll(List<Discount> discounts) {
        this.discounts.addAll(discounts);
    }

    public void delete(Discount item) {
        discounts.remove(item);
    }
}
