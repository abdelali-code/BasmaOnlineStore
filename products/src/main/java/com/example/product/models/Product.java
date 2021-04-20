package com.example.product.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 65)
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "discount")
    private int discount;

    @ElementCollection
    protected Set<String> productImages = new HashSet();

    @OneToOne
    private Category category;

    @Transient
    private long tempCategory;

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

    public long getTempCategory() {
        return tempCategory;
    }

    public void setTempCategory(long tempCategory) {
        this.tempCategory = tempCategory;
    }
}
