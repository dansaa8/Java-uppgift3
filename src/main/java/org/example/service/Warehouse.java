package org.example.service;

import org.example.entities.Product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Warehouse {
    private final Set<Product> products;

    public Warehouse() {
        this.products = new HashSet<>();
    }


    public Object addProduct(Product p) {
        if (p == null || p.name().isEmpty())
            return false;
        if (p.rating() > 10)
            return false;

        return true;
    }
}
