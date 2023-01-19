package com.victor.bookstoresystem.repositories;

import com.victor.bookstoresystem.entities.StockItem;
import com.victor.bookstoresystem.entities.products.Product;
import com.victor.bookstoresystem.enums.Category;

import java.util.LinkedList;
import java.util.List;

public class ItemRepository {

    private final List<StockItem<Product>> stockItems = new LinkedList<>();


    public List<StockItem<Product>> findAll() {
        return stockItems;
    }

    public List<StockItem<Product>> findByCategory(Category category) {
        return stockItems.stream().filter(item -> item.getCategory() == category).toList();
    }

    public StockItem<Product> findById(int id) {
        return stockItems.stream().filter(item -> item.getId() == id).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Item não encontrado"));
    }

    public void editProductById(int id, Product product) {
        StockItem<Product> stockItem = findById(id);
        stockItem.setProduct(product);
    }

    public void editProductCategoryById(int id, Category category) {
        StockItem<Product> stockItem = findById(id);
        stockItem.setCategory(category);
    }

    public Integer getQuantityByCategory(Category category) {
        return findByCategory(category).size();
    }

    public Integer getQuantity() {
        return stockItems.size();
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

    public void incrementProduct(StockItem<Product> stockItem) {
        stockItem.setQuantity(stockItem.getQuantity() + 1);
    }

    public void incrementProduct(StockItem<Product> stockItem, Integer quantity) {
        stockItem.setQuantity(stockItem.getQuantity() + quantity);
    }

    public void subtractProduct(StockItem<Product> stockItem) {
        if (stockItem.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantidade de produtos insuficiente");
        }

        stockItem.setQuantity(stockItem.getQuantity() - 1);
    }

    public void subtractProduct(StockItem<Product> stockItem, Integer quantity) {
        if (stockItem.getQuantity() - quantity < 0) {
            throw new IllegalArgumentException("Quantidade de produtos insuficiente");
        }

        stockItem.setQuantity(stockItem.getQuantity() - quantity);
    }
}
