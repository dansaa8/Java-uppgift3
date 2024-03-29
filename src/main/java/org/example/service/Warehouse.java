package org.example.service;

import org.example.entities.Category;
import org.example.entities.Product;
import org.example.entities.ProductRecord;

import java.time.LocalDate;
import java.util.*;

import static org.example.service.Queries.*;
import static org.example.service.ListUpdater.*;

public class Warehouse {
    private final List<Product> products;

    public Warehouse() {
        this.products = new ArrayList<>();
    }

    public boolean addProduct(ProductRecord p) {
        return (insertIntoList(products, p));
    }

    public boolean modifyProduct(ProductRecord p) {
        return updateProduct(products, p);
    }

    public Optional<ProductRecord> getProduct(int id) {
        return Optional.ofNullable(findProduct(products, id));
    }

    public List<ProductRecord> getAllProducts() {
        return products.stream().map(ProductRecord::new).toList();
    }

    public List<ProductRecord> getProductsByCategory(Category desiredCategory) {
        return Queries.findProductsByCategory(products, desiredCategory);
    }

    public List<ProductRecord> getProductsCreatedAfterDate(LocalDate desiredDate) {
        return findProductsCreatedAfterDesiredDate(products, desiredDate);
    }

    public List<ProductRecord> getProductsModifiedAfterDate(LocalDate desiredDate) {
        return findProductsModifiedAfterDesiredDate(products, desiredDate);
    }

    public List<String> getExistingCategories() {
        return findExistingCategories(products);
    }

    public Map<String, Long> getFirstLetters() {
        return countFirstCharacterOccurrence(products);
    }

    public List<ProductRecord> getProductsWithHighestRating(LocalDate date) {
        return findProductsWithHighestRatingThisMonth(products, date);
    }
}
