package org.example.service;

import org.example.entities.Product;
import org.example.entities.Utils;

import java.util.*;

import static org.example.entities.Utils.*;

public class Warehouse {
    private final Map<Integer, Product> products;

    public Warehouse() {
        this.products = new HashMap<>();
    }


    public Object addProduct(Product p) {
        if (p == null)
            return false;

        boolean isKeyExists = products.keySet().stream().anyMatch(id -> id == p.id());

        if (isKeyExists) return false;

        if (isValid(p)) {
            products.put(p.id(), p);
            System.out.println(products);
            return true;
        }

        return false;


    }
}
