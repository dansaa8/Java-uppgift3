package org.example.entities;

import java.util.*;

public record ProductRecord(int id, String name, Category category, int rating, Date createdAt, Date lastModified) {


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


}

