package com.victor.bookstoresystem.repositories;

import com.victor.bookstoresystem.entities.StockItem;
import com.victor.bookstoresystem.entities.ItemRepository;
import com.victor.bookstoresystem.entities.Product;
import com.victor.bookstoresystem.enums.Category;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class StockRepository implements ItemRepository {
    private final List<StockItem<Product>> stockItems = new LinkedList<>();

    public List<StockItem<Product>> findAll() {
        return stockItems;
    }

    public StockItem<Product> findById(Integer id) {
        return stockItems.stream()
                .filter(item -> Objects.equals(item.getId(), id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }

    public List<StockItem<Product>> findAllByCategory(Category category) {
        return stockItems.stream()
                .filter(item -> item.getProduct().getCategory() == category)
                .toList();
    }

    public void save(StockItem<Product> stockItem) {
        if (stockItems.contains(stockItem)) {
            stockItem.increaseQuantity();
        } else {
            stockItems.add(stockItem);
        }
    }

    public void saveAll(List<StockItem<Product>> stockItems) {
        stockItems.forEach(item -> {
            if (this.stockItems.contains(item)) {
                item.increaseQuantity();
            } else {
                this.stockItems.add(item);
            }
        });
    }

    public void delete(StockItem<Product> stockItem) {
        if (!stockItems.contains(stockItem)) {
            throw new RuntimeException("Item not found");
        }

        if (stockItem.getQuantity() > 1) {
            stockItem.decreaseQuantity();
            return;
        }

        stockItems.remove(stockItem);
    }

    public void deleteAll(StockItem<Product> stockItem) {
        if (!stockItems.contains(stockItem)) {
            throw new RuntimeException("Item not found");
        }

        stockItems.remove(stockItem);
    }
}
