package com.victor.bookstoresystem.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class Purchase {
    private final List<PurchaseItem> items = new LinkedList<>();
    private final Date date = new Date();
    private boolean isPaid = false;
}
