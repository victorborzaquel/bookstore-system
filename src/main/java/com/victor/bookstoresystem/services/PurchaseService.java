package com.victor.bookstoresystem.services;

import com.victor.bookstoresystem.entities.Purchase;
import com.victor.bookstoresystem.entities.PurchaseItem;

public class PurchaseService {

    private PurchaseService(){}

    public void addItem(Purchase purchase, PurchaseItem item) {
        purchase.getItems().add(item);
    }

    public void removeItem(Purchase purchase, PurchaseItem item) {
        purchase.getItems().remove(item);
    }

    public void incrementItemQuantity(PurchaseItem item) {
        item.setQuantity(item.getQuantity() + 1);
    }

    public void incrementItemQuantity(PurchaseItem item, int quantity) {
        item.setQuantity(item.getQuantity() + quantity);
    }

    public void decrementItemQuantity(PurchaseItem item) {
        item.setQuantity(item.getQuantity() - 1);
    }

    public void decrementItemQuantity(PurchaseItem item, int quantity) {
        item.setQuantity(item.getQuantity() - quantity);
    }

    public void pay(Purchase purchase) {
        purchase.setPaid(true);
    }
}
