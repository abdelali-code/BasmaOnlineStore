package com.example.product.service;

import com.example.product.models.Product;
import com.example.product.request.ProductRequest;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product addProduct(ProductRequest product);
    void deleteAllProducts();

    Product getProductById(long productId);

    Product updateProduct(long productId, ProductRequest product);

    void deleteProduct(long productId);
}
