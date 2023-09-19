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


    public boolean addProduct(Product p) {
        if (isValid(p) && !nameExists(products, p)) {
            products.add(p);
            return true;
        }
        return false;
    }

    public boolean modifyProduct(Product p) {
        if (isValid(p) && nameExists(products, p)) {
            return true;
        }
        return false;
    }

    public Optional<Product> getProduct(int id) {
        return Optional.ofNullable(findProduct(products, id));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }
}
