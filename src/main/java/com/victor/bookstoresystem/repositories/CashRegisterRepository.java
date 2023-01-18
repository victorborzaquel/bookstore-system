package com.victor.bookstoresystem.repositories;

import com.victor.bookstoresystem.entities.CashRegister;
import com.victor.bookstoresystem.entities.products.Product;

import java.math.BigDecimal;

public class CashRegisterRepository {

    private CashRegisterRepository(){}

    public static void addCash(CashRegister cashRegister, Integer cash) {
        cashRegister.setCash(cashRegister.getCash().add(new BigDecimal(cash.toString())));
    }

    public static void removeCash(CashRegister cashRegister, Integer cash) {
        if (cashRegister.getCash().doubleValue() - cash < 0) {
            throw new IllegalArgumentException("Dinheiro insuficiente");
        }

        cashRegister.setCash(cashRegister.getCash().min(new BigDecimal(cash.toString())));
    }

    public static void sellProduct(CashRegister cashRegister, Product product, BigDecimal cash) {
//        if (product.getPrice().subtract(cash) > 0 ) {
//            throw new RuntimeException("Dinheiro insuficiente");
//        }
//        CategoriesRepository

    }
}
