package com.victor.bookstoresystem.repositories;

import com.victor.bookstoresystem.entities.Discount;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class DiscountRepository {
    private final List<Discount> discounts = new ArrayList<>();

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
