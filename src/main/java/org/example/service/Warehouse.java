package org.example.service;

import org.example.entities.Category;
import org.example.entities.Product;
import org.example.entities.ProductRecord;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static org.example.entities.Utils.*;
import static org.example.service.Filters.*;

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

    public List<ProductRecord> getAllProducts(Category desiredCategory) {
        return Filters.getProductsInCategory(products, desiredCategory);
    }

    public List<ProductRecord> getAllProducts(DateField desiredDateField, LocalDate targetDate) {
        if (desiredDateField == DateField.CREATED_AT)
            return getProductsCreatedAfterDesiredDate(products, targetDate);
        else
            return getProductsLastModifiedAfterDesiredDate(products,targetDate);
    }
}
