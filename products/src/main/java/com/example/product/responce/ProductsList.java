package com.example.product.responce;

import com.example.product.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsList {

    private List<ProductResponce> products;

    public ProductsList() {
        this.products = new ArrayList<>();
    }


    public List<ProductResponce> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponce> products) {
        this.products = products;
    }

    public void addSingleProducts(ProductResponce productResponce) {
        this.products.add(productResponce);
    }
}
