package com.victor.bookstoresystem.entities;

import com.victor.bookstoresystem.enums.Category;
import com.victor.bookstoresystem.repositories.DiscountRepository;
import com.victor.bookstoresystem.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CashRegister {
    private Double cash;
    private IdentityCard identityCard;
    private final ItemRepository<StockItem> stockRepository;
    private final ItemRepository<OrderItem> orderRepository;
    private final DiscountRepository discountRepository;

    public void sell() {
        double discount = calculateDiscount();
        double total = calculateTotalPrice();

        cash += Math.max(0, total - discount);
        orderRepository.getList().clear();
    }

    public double calculateTotalPrice() {
        return orderRepository.getList().stream()
                .mapToDouble(orderItem -> orderItem.getProduct().getPrice() * orderItem.getQuantity())
                .sum();
    }
    public double calculateDiscount() {
        List<Category> categories = List.of(Category.values());

        double discountPrice = 0;
        for (Category category : categories) {
            double orderCategoryPrice = 0;

            for (OrderItem orderItem : orderRepository.findAllByCategory(category)) {
                orderCategoryPrice += orderItem.getProduct().getPrice() * orderItem.getQuantity();
            }

            for (Discount discount : discountRepository.getDiscounts()) {
                discountPrice = Math.max(discountPrice, discount.apply(category, orderCategoryPrice));
            }
        }

        return discountPrice;
    }

    public void addProductToOrder(int id, Integer quantity) {
        StockItem stockItem = stockRepository.findById(id);

        if (identityCard.getAge() < stockItem.getProduct().getAgeGreaterThan()) {
            throw new IllegalArgumentException("Age is not valid");
        }

        if (stockItem.getQuantity() < quantity) {
            throw new IllegalArgumentException("Not enough stock");
        }

        stockItem.setQuantity(stockItem.getQuantity() - quantity);

        try {
            OrderItem orderItem = orderRepository.findById(id);
            orderItem.setQuantity(orderItem.getQuantity() + quantity);
        } catch (Exception e) {
            OrderItem newOrder = new OrderItem(id, quantity, stockItem.getProduct());
            orderRepository.getList().add(newOrder);
        }
    }

    public void removeProductFromOrder(int id, Integer quantity){
        OrderItem orderItem = orderRepository.findById(id);
        StockItem stockItem = stockRepository.findById(id);

        if (orderItem.getQuantity() < quantity) {
            throw new IllegalArgumentException("Not enough stock");
        } else if (orderItem.getQuantity() == quantity) {
            orderRepository.getList().remove(orderItem);
        } else {
            orderItem.setQuantity(orderItem.getQuantity() - quantity);
        }

        stockItem.setQuantity(stockItem.getQuantity() + quantity);
    }
}
