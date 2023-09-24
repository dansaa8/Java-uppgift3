package org.example.entities;

import java.time.LocalDateTime;
import java.util.*;

public record ProductRecord(int id, String name, Category category, int rating, LocalDateTime createdAt, LocalDateTime lastModified) {


    public ProductRecord(Product other) {
        this(
                other.getId(),
                other.getName(),
                other.getCategory(),
                other.getRating(),
                other.getCreatedAt(),
                other.getLastModified());
    }

    public ProductRecord(ProductRecord other) {
        this(
                other.id(),
                other.name(),
                other.category(),
                other.rating(),
                other.createdAt(),
                other.lastModified());
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

