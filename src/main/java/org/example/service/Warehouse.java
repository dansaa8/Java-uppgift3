package org.example.service;

import org.example.entities.Product;
import org.example.entities.Utils;

import java.util.*;
import java.util.function.Predicate;

import static org.example.entities.Utils.*;

public class Warehouse {
    private final List<Product> products;

    public Warehouse() {
        this.products = new ArrayList<>();
    }


    public Object addProduct(Product p) {
        if (p == null)
            return false;


        boolean nameExists = products.stream()
                .anyMatch(product ->
                        product.name().equalsIgnoreCase(p.name())
                );

        if (isValid(p) && !nameExists) {
            products.add(p);
            System.out.println(products);
            return true;
        }

        return false;


    }
}
