package com.example.product.request;


import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

public class ProductRequest {


    @Size(min = 3, message = "your message must be greater than 3 character")
    private String name;
    @Min(value = 1, message = "your message must be greater than 1 dirhams")
    private double price;
    private int discount;
    private Set<String> productImages = new HashSet();
    private long categoryId;
    @Size(min = 6, message = "description must be greater than 6 character")
    private String description;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", productImages=" + productImages +
                ", categoryId=" + categoryId +
                ", description='" + description + '\'' +
                '}';
    }
}
