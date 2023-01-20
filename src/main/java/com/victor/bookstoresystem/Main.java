package com.victor.bookstoresystem;

import com.victor.bookstoresystem.entities.CashRegister;
import com.victor.bookstoresystem.entities.IdentityCard;
import com.victor.bookstoresystem.entities.OrderItem;
import com.victor.bookstoresystem.entities.StockItem;
import com.victor.bookstoresystem.entities.products.Book;
import com.victor.bookstoresystem.enums.Category;
import com.victor.bookstoresystem.repositories.DiscountRepository;
import com.victor.bookstoresystem.repositories.ItemRepository;
import com.victor.bookstoresystem.utils.Default;

public class Main {
    public static void main(String[] args) {
        ItemRepository<OrderItem> order = new ItemRepository<>();
        IdentityCard identityCard = Default.identityCard();
        ItemRepository<StockItem> stock = new ItemRepository<>();
        DiscountRepository discounts = new DiscountRepository();
        CashRegister cashRegister = new CashRegister(0.0, identityCard, stock, order, discounts);

        order.addAll(Default.order());
        stock.addAll(Default.stock());
        discounts.addAll(Default.discounts());

        // Adicionar
        stock.add(new StockItem(3, new Book("Livro", 12d, 16)));

        // Ver
        System.out.println(stock.findById(2));

        // Alterar
        stock.findById(2).getProduct().setPrice(100d);

        // Remover
        stock.removeById(2);

        // quantos itens de um tipo específico existem no estoque.
        System.out.println(stock.findAllByCategory(Category.BOOK).size());

        // listagem completa dos itens em estoque
        stock.getList().forEach(System.out::println);

        // listagem dos itens em estoque por categoria.
        stock.findAllByCategory(Category.BOOK).forEach(System.out::println);

        // operação de compra.
        cashRegister.addProductToOrder(1, 8);
        cashRegister.addProductToOrder(3, 1);

        cashRegister.removeProductFromOrder(1, 1);

        cashRegister.sell();


        System.out.println(cashRegister.getCash());
        stock.getList().forEach(System.out::println);
    }
}
