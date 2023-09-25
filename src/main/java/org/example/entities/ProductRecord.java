package org.example.entities;

import java.time.LocalDate;
import java.util.*;

public record ProductRecord(int id, String name, Category category, int rating, LocalDate createdAt, LocalDate lastModified) {


    public ProductRecord(Product other) {
        this(
                other.getId(),
                other.getName(),
                other.getCategory(),
                other.getRating(),
                other.getCreatedAt(),
                other.getLastModified());
    }

    @Override
    public String toString() {
        return "ProductRecord[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "category=" + category + ", " +
                "rating=" + rating + ", " +
                "createdAt=" + createdAt + ", " +
                "lastModified=" + lastModified + ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRecord that = (ProductRecord) o;
        return id == that.id && rating == that.rating && Objects.equals(name, that.name) && category == that.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, rating);
    }
}

