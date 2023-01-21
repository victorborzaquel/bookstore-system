package com.victor.bookstoresystem;

import com.victor.bookstoresystem.entities.CashRegister;
import com.victor.bookstoresystem.entities.IdentityCard;
import com.victor.bookstoresystem.entities.OrderItem;
import com.victor.bookstoresystem.entities.StockItem;
import com.victor.bookstoresystem.entities.products.Book;
import com.victor.bookstoresystem.enums.Category;
import com.victor.bookstoresystem.repositories.DiscountRepository;
import com.victor.bookstoresystem.repositories.ItemRepository;
import com.victor.bookstoresystem.services.OrderService;
import com.victor.bookstoresystem.utils.Default;

public class Main {
    public static void main(String[] args) {
        final ItemRepository<StockItem> stock = new ItemRepository<>();
        final DiscountRepository discounts = new DiscountRepository();
        final ItemRepository<OrderItem> orderReposirory = new ItemRepository<>();

        final CashRegister cashRegister = new CashRegister(0.0, discounts);

        final IdentityCard identityCard = Default.identityCard();
        final OrderService order = new OrderService(orderReposirory, identityCard);

        stock.addAll(Default.stock());
        discounts.add(Default.discount());

        // Adicionar
        stock.add(new StockItem(3, new Book("Livro", 12d, 16)));

        // Ver
        System.out.println(stock.findById(2));

        // Alterar
        stock.findById(2).getProduct().setPrice(100d);

        // Remover
        stock.removeById(2);

        // quantos itens de um tipo específico existem no estoque
        System.out.println(stock.findAllByCategory(Category.BOOK).size());

        // listagem completa dos itens em estoque
        stock.findAll().forEach(System.out::println);

        // listagem dos itens em estoque por categoria
        stock.findAllByCategory(Category.BOOK).forEach(System.out::println);

        // operação de compra.
        order.addProductToOrder(stock, 1, 8);
        order.addProductToOrder(stock, 3, 1);

        order.removeProductFromOrder(stock, 1, 1);

        cashRegister.sell(order);

        System.out.println(cashRegister.getCash());
        stock.findAll().forEach(System.out::println);
    }
}
