package org.example.service;

import org.example.entities.Category;
import org.example.entities.DateTimeField;
import org.example.entities.Product;
import org.example.entities.ProductRecord;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static org.example.entities.Utils.*;

public class Warehouse {
    private final List<Product> products;

    public Warehouse() {
        this.products = new ArrayList<>();
    }


    public boolean addProduct(ProductRecord p) {
        if (isValid(p) && !nameExists(products, new ProductRecord(p))) {
            products.add(new Product(p));
            return true;
        }
        return false;
    }

    public boolean modifyProduct(ProductRecord p) {
        return isValid(p) && updateProduct(products, p);
    }

    public Optional<ProductRecord> getProduct(int id) {
        return Optional.ofNullable(findProduct(products, id));
    }

    public List<ProductRecord> getAllProducts() {
        return products.stream()
                .map(ProductRecord::new).toList();
    }

    public List<ProductRecord> getAllProducts(Category category) {
        return products.stream()
                .filter(product -> product.getCategory() == category)
                .map(ProductRecord::new)
                .sorted(Comparator.comparing(ProductRecord::name))
                .toList();
    }

    public List<ProductRecord> getAllProducts(DateTimeField dateTimeField, LocalDate targetDate) {
        return products.stream()
                .filter(product -> filterByDateType(product, dateTimeField, targetDate))
                .map(ProductRecord::new)
                .sorted(Comparator.comparing(ProductRecord::createdAt))
                .collect(Collectors.toList());
    }
}
