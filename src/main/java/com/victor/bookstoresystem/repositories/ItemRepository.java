package com.victor.bookstoresystem.repositories;

import com.victor.bookstoresystem.entities.Item;
import com.victor.bookstoresystem.entities.products.Product;
import com.victor.bookstoresystem.enums.Category;

import java.util.LinkedList;
import java.util.List;

public class ItemRepository {

    private static final List<Item<Product>> items = new LinkedList<>();

    private ItemRepository() {}

    public static List<Item<Product>> findAll() {
        return items;
    }

    public static List<Item<Product>> findByCategory(Category category) {
        return items.stream().filter(item -> item.getCategory() == category).toList();
    }

    public static Item<Product> findById(int id) {
        return items.stream().filter(item -> item.getId() == id).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Item não encontrado"));
    }

    public static void editProductById(int id, Product product) {
        Item<Product> item = findById(id);
        item.setProduct(product);
    }

    public static void editProductCategoryById(int id, Category category) {
        Item<Product> item = findById(id);
        item.setCategory(category);
    }

    public static Integer getQuantityByCategory(Category category) {
        return findByCategory(category).size();
    }

    public static Integer getQuantity() {
        return items.size();
    }

    public static void add(Item<Product> item) {
        items.add(item);
    }

    public static void addAll(List<Item<Product>> item) {
        items.addAll(item);
    }

    public static void remove(Item<Product> item) {
        items.remove(item);
    }

    public static void removeById(int id) {
        Item<Product> item = findById(id);

        items.remove(item);
    }

    public static void incrementProduct(Item<Product> item) {
        item.setQuantity(item.getQuantity() + 1);
    }

    public static void incrementProduct(Item<Product> item, Integer quantity) {
        item.setQuantity(item.getQuantity() + quantity);
    }

    public static void subtractProduct(Item<Product> item) {
        if (item.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantidade de produtos insuficiente");
        }

        item.setQuantity(item.getQuantity() - 1);
    }

    public static void subtractProduct(Item<Product> item, Integer quantity) {
        if (item.getQuantity() - quantity < 0) {
            throw new IllegalArgumentException("Quantidade de produtos insuficiente");
        }

        item.setQuantity(item.getQuantity() - quantity);
    }
}
