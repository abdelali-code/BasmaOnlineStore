package com.example.product.service;

import com.example.product.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product addProduct(Product product);
    void deleteAllProducts();

    Product getProductById(long productId);

    Product updateProduct(long productId, Product product);

    void deleteProduct(long productId);
}
