package com.example.product.service;

import com.example.product.models.Product;
import com.example.product.request.ProductRequest;
import com.example.product.responce.ProductResponce;
import com.example.product.responce.ProductsList;

import java.util.List;

public interface ProductService {
    ProductsList getAll();
    ProductResponce addProduct(ProductRequest product);
    void deleteAllProducts();

    ProductResponce getProductById(long productId);

    ProductResponce updateProduct(long productId, ProductRequest product);

    void deleteProduct(long productId);

    void deleteProductsByIdsIn(List<Long> ids);
}
