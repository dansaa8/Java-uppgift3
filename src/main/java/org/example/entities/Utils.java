package org.example.entities;

import java.time.LocalDate;
import java.util.List;

public final class Utils {
    private Utils() {}

    public static boolean isValid(ProductRecord p) {
        if (p == null) return false;

        return isInRange(p.rating()) &&
                !isNullOrEmpty(p.name()) &&
                p.id() >= 0;
    }

    private static boolean isInRange(int rating) {
        return rating >= 0 && rating <= 10;
    }

    private static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean nameExists(List<Product> pList, ProductRecord p) {
        return pList.stream()
                .anyMatch(product ->
                        product.getName().equalsIgnoreCase(p.name())
                );
    }

    public static ProductRecord findProduct(List<Product> pList, int id) {
        return pList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .map(ProductRecord::new)
                .orElse(null);
    }

    public static boolean updateProduct(List<Product> pList, ProductRecord p)  {
        var foundProduct = pList.stream()
                .filter(product -> product.getId() == p.id())
                .findFirst();

        if(foundProduct.isPresent()) {
            var prodUpdate = foundProduct.get();
            prodUpdate.setName(p.name());
            prodUpdate.setCategory(p.category());
            prodUpdate.setRating(p.rating());
            prodUpdate.setLastModified(LocalDate.now());

            return true;
        }

        return false;
    }

    public static boolean filterByDateType(Product product, DateTimeField dateTimeField, LocalDate targetDate) {
        return switch (dateTimeField) {
            case CREATED_AT -> product.getCreatedAt().isAfter(targetDate);
            case LAST_MODIFIED -> product.getLastModified().isAfter(targetDate);
            default ->
                // Handle the case when dateType is something else
                    false;
        };
    }

}
