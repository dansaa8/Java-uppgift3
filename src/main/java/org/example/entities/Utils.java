package org.example.entities;

public final class Utils {
    private Utils() {}

    public static boolean isValid(Product p) {
        return isInRange(p.rating());
    }

    private static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    private static boolean isInRange(int rating) {
        return rating >= 0 && rating <= 10;
    }

    private static boolean isNegative(int id) {
        return id < 0;
    }


}
