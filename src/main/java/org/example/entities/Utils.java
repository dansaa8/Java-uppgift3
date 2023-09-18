package org.example.entities;

import java.util.List;

public final class Utils {
    private Utils() {}

    public static boolean isValid(Product p) {
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

    public static boolean nameExists(List<Product> pList, Product p) {
        return pList.stream()
                .anyMatch(product ->
                        product.name().equalsIgnoreCase(p.name())
                );
    }

}
