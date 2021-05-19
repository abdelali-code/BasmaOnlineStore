package com.example.product.service;

import com.example.product.models.ParentCategory;
import com.example.product.request.ParentCategoryRequest;

import java.util.List;

public interface ParentCategoryService {
    List<ParentCategory> getAll();
    ParentCategory getParentCategoryById(long id);
    void deleteAll();
    void deleteCategoryById(long id);

    ParentCategory addParentCategory(ParentCategoryRequest parentCategoryRequest);

    ParentCategory updateParentCategoy(long id, ParentCategoryRequest parentCategoryRequest);
}
