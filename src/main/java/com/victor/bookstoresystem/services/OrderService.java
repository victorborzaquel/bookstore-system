package com.victor.bookstoresystem.services;

import com.victor.bookstoresystem.entities.*;
import com.victor.bookstoresystem.enums.Category;
import com.victor.bookstoresystem.interfaces.FindDiscount;
import com.victor.bookstoresystem.interfaces.FindItem;
import com.victor.bookstoresystem.repositories.ItemRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class OrderService {
    private final ItemRepository<OrderItem> order;
    private final IdentityCard identityCard;

    public void addProductToOrder(FindItem<StockItem> stock , int id, int quantity) {
        final StockItem stockItem = stock.findById(id);

        if (identityCard.getAge() < stockItem.getProduct().getAgeGreaterThan()) {
            throw new IllegalArgumentException("Age is not valid");
        }

        if (stockItem.getQuantity() < quantity) {
            throw new IllegalArgumentException("Not enough stock");
        }

        try {
            OrderItem orderItem = order.findById(id);
            orderItem.setQuantity(orderItem.getQuantity() + quantity);
        } catch (Exception e) {
            OrderItem newOrder = new OrderItem(id, quantity, stockItem.getProduct());
            order.add(newOrder);
        } finally {
            stockItem.setQuantity(stockItem.getQuantity() - quantity);
        }
    }

    public void removeProductFromOrder(FindItem<StockItem> stock , int id, int quantity) {
        final OrderItem orderItem = order.findById(id);
        final StockItem stockItem = stock.findById(id);

        if (orderItem.getQuantity() < quantity) {
            throw new IllegalArgumentException("Not enough stock");
        } else if (orderItem.getQuantity() == quantity) {
            order.remove(orderItem);
        } else {
            orderItem.setQuantity(orderItem.getQuantity() - quantity);
        }

        stockItem.setQuantity(stockItem.getQuantity() + quantity);
    }

    public double calculateDiscount(FindDiscount discounts) {
        final List<Category> categories = List.of(Category.values());

        double discountPrice = 0;
        for (Category category : categories) {
            double orderCategoryPrice = 0;

            for (OrderItem orderItem : order.findAllByCategory(category)) {
                orderCategoryPrice += orderItem.getProduct().getPrice() * orderItem.getQuantity();
            }

            for (Discount discount : discounts.findAll()) {
                discountPrice = Math.max(discountPrice, discount.apply(category, orderCategoryPrice));
            }
        }

        return discountPrice;
    }

    public double calculateTotalPrice() {
        return order.findAll().stream()
                .mapToDouble(orderItem -> orderItem.getProduct().getPrice() * orderItem.getQuantity())
                .sum();
    }

    public void clear() {
        order.clear();
    }
}
