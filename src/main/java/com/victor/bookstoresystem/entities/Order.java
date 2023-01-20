package com.victor.bookstoresystem.entities;

import com.victor.bookstoresystem.enums.Category;
import com.victor.bookstoresystem.enums.IdType;
import com.victor.bookstoresystem.repositories.DiscountRepository;
import com.victor.bookstoresystem.repositories.StockRepository;
import com.victor.bookstoresystem.utils.Id;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Getter
@ToString
public class Order implements Purchase {
    private final Integer id = Id.generate(IdType.ORDER);
    private final StockRepository items;
    private LocalDate payDate;
    private Double price;
    private Double discount;
    private boolean isPay = false;

    public Order(StockRepository items) {
        this.items = items;
    }

    public boolean close() {
        if (isPay) {
            return false;
        }

        discount = getDiscount();
        price = getTotalPrice() - discount;
        payDate = LocalDate.now();
        isPay = true;
        return true;
    }

    public Double getTotalPrice(){
        return items.findAll().stream()
                .mapToDouble(item -> item.getQuantity() * item.getProduct().getPrice())
                .sum();
    }

    public Double getTotalPriceByCategory(Category category){
        return items.findAllByCategory(category).stream()
                .mapToDouble(item -> item.getQuantity() * item.getProduct().getPrice())
                .sum();
    }

    public Double getDiscount(DiscountRepository discounts) {
        List<Category> categories = Arrays.stream(Category.values()).toList();
        double totalDiscount = 0d;
        for (Category category : categories) {
            double categoryPrice = getTotalPriceByCategory(category);

            for (Discount discount : discounts.findAll()) {
                double currentDiscount = discount.aplicar(category, categoryPrice);

                totalDiscount = Math.max(totalDiscount, currentDiscount);
            }
        }

        return totalDiscount;
    }
}
