package com.victor.bookstoresystem.repositories;

import com.victor.bookstoresystem.entities.StockItem;
import com.victor.bookstoresystem.entities.products.Product;

import java.util.LinkedList;
import java.util.List;

public class PurchaseRepository {
    private final List<StockItem<Product>> stockItems = new LinkedList<>();

    public List<StockItem<Product>> findAll() {
        return stockItems;
    }

    public void add(StockItem<Product> stockItem) {
        stockItems.add(stockItem);
    }

    public void addAll(List<StockItem<Product>> stockItem) {
        stockItems.addAll(stockItem);
    }

    public void remove(StockItem<Product> stockItem) {
        stockItems.remove(stockItem);
    }

    public void removeById(int id) {
        StockItem<Product> stockItem = findById(id);
        stockItems.remove(stockItem);
    }

    public StockItem<Product> findById(int id) {
        return stockItems.stream().filter(item -> item.getId() == id).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Item não encontrado"));
    }

}
