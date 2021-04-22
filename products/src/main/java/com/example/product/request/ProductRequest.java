package com.example.product.request;


import java.util.HashSet;
import java.util.Set;

public class ProductRequest {

    private String name;
    private double price;
    private int discount;
    private Set<String> productImages = new HashSet();
    private long categoryId;


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

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
