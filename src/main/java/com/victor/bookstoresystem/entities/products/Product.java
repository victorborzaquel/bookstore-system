package com.victor.bookstoresystem.entities.products;

import com.victor.bookstoresystem.enums.Category;
import com.victor.bookstoresystem.enums.IdType;
import com.victor.bookstoresystem.utils.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public abstract class Product {
    protected final Integer id = Id.generate(IdType.PRODUCT);
    protected Category category;
    protected String name;
    protected Double price;
    protected Integer ageGreaterThan;
}
