package org.example.service;

import org.example.entities.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

final class Queries {
    private Queries(){};

    static List<ProductRecord> getProductsInCategory(List<Product> products, Category category) {
        return products.stream()
                .filter(product -> product.getCategory() == category)
                .map(ProductRecord::new)
                .sorted(Comparator.comparing(ProductRecord::name))
                .toList();
    }

    static List<ProductRecord> getProductsCreatedAfterDesiredDate(List<Product> products, LocalDate targetDate) {
        return products.stream()
                .filter(product -> product.getCreatedAt().isAfter(targetDate))
                .map(ProductRecord::new)
                .sorted(Comparator.comparing(ProductRecord::createdAt))
                .toList();
    }

    static List<ProductRecord> getProductsLastModifiedAfterDesiredDate(List<Product> products, LocalDate targetDate) {
        return products.stream()
                .filter(product -> product.getLastModified().isAfter(targetDate))
                .map(ProductRecord::new)
                .sorted(Comparator.comparing(ProductRecord::lastModified))
                .toList();
    }

    static ProductRecord findProduct(List<Product> pList, int id) {
        return pList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .map(ProductRecord::new)
                .orElse(null);
    }

    static List<String> findExistingCategories(List<Product> pList) {
        return pList.stream()
                .map(p -> p.getCategory().toString())
                .distinct()
                .toList();
    }
}
