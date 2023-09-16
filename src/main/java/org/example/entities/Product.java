package org.example.entities;

import java.util.*;

public record Product(int id, String name, Category category, int rating, Date createdAt, Date lastModified) {

    @Override
    public String toString() {
        return "Product[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "category=" + category + ", " +
                "rating=" + rating + ", " +
                "createdAt=" + createdAt + ", " +
                "lastModified=" + lastModified + ']';
    }


}

