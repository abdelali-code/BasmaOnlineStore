package com.example.product.repository;

import com.example.product.models.ParentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentCategoryRepository extends JpaRepository<ParentCategory, Long> {
}
