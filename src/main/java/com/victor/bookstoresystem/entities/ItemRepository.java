package com.victor.bookstoresystem.entities;

import com.victor.bookstoresystem.enums.Category;

import java.util.List;

public interface ItemRepository {
    List<StockItem<Product>> findAll();
    StockItem<Product> findById(Integer id);
    List<StockItem<Product>> findAllByCategory(Category category);
    void save(StockItem<Product> stockItem);
    void saveAll(List<StockItem<Product>> stockItems);
    void delete(StockItem<Product> stockItem);
    void deleteAll(StockItem<Product> stockItem);
}
