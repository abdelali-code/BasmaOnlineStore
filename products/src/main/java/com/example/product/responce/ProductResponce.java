package com.example.product.responce;

import com.example.product.models.Category;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

public class ProductResponce {

    private long id;
    private String name;
    private double price;
    private int discount;
    private Set<String> productImages = new HashSet();
    private Category category;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Set<String> getProductImages() {
        return productImages;
    }

    public void setProductImages(Set<String> productImages) {
        this.productImages = productImages;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
