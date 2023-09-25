package org.example.service;

import org.example.entities.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public final class Filters {
    public static List<ProductRecord> getProductsInCategory(List<Product> products, Category category) {
        return products.stream()
                .filter(product -> product.getCategory() == category)
                .map(ProductRecord::new)
                .sorted(Comparator.comparing(ProductRecord::name))
                .toList();
    }

    public static List<ProductRecord> getProductsCreatedAfterDesiredDate(List<Product> products, LocalDate targetDate) {
        return products.stream()
                .filter(product -> product.getCreatedAt().isAfter(targetDate))
                .map(ProductRecord::new)
                .sorted(Comparator.comparing(ProductRecord::createdAt))
                .toList();
    }

    public static List<ProductRecord> getProductsLastModifiedAfterDesiredDate(List<Product> products, LocalDate targetDate) {
        return products.stream()
                .filter(product -> product.getLastModified().isAfter(targetDate))
                .map(ProductRecord::new)
                .sorted(Comparator.comparing(ProductRecord::lastModified))
                .toList();
    }

}
