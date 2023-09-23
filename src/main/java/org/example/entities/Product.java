package org.example.entities;

import java.util.*;

public final class Product {
    private final int id;
    private String name;
    private Category category;
    private int rating;
    private final Date createdAt;
    private Date lastModified;

    public Product(int id, String name, Category category, int rating, Date createdAt, Date lastModified) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.createdAt = createdAt;
        this.lastModified = lastModified;
    }

    public Product(ProductRecord other) {
        this.id = other.id();
        this.name = other.name();
        this.category = other.category();
        this.rating = other.rating();
        this.createdAt = other.createdAt();
        this.lastModified = other.lastModified();
    }

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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getRating() {
        return rating;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Product) obj;
        return this.id == that.id &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.category, that.category) &&
                this.rating == that.rating &&
                Objects.equals(this.createdAt, that.createdAt) &&
                Objects.equals(this.lastModified, that.lastModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, rating, createdAt, lastModified);
    }


}

