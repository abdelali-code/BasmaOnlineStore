package com.example.product.repository;

import com.example.product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Product, Long> {
    void deleteAllByIdIn(List<Long> ids);
}
