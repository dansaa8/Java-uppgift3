package org.example.service;

import org.example.entities.Product;
import org.example.entities.Utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Warehouse {
    private final Set<Product> products;

    public Warehouse() {
        this.products = new HashSet<>();
    }


    public Object addProduct(Product p) {
        if (p == null)
            return false;

        return Utils.isValid(p);

    }
}
