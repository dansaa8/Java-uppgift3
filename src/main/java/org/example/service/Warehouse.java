package org.example.service;

import org.example.entities.Product;
import org.example.entities.ProductRecord;
import org.example.entities.Utils;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.example.entities.Utils.*;

public class Warehouse {
    private final List<Product> products;

    public Warehouse() {
        this.products = new ArrayList<>();
    }


    public boolean addProduct(ProductRecord p) {
        if (isValid(p) && !nameExists(products, new Product(p))) {
            products.add(new Product(p));
            return true;
        }
        return false;
    }

//    public boolean modifyProduct(Product p) {
//        if (isValid(p) && nameExists(products, p)) {
//            return true;
//        }
//        return false;
//    }

    public Optional<ProductRecord> getProduct(int id) {
        return Optional.ofNullable(findProduct(products, id));
    }

    public List<ProductRecord> getAllProducts() {
        List<ProductRecord> prodRecords = products.stream()
                .map(ProductRecord::new)
                        .collect(Collectors.toList());
        System.out.println(prodRecords);

        return Collections.unmodifiableList(prodRecords);
    }
}
