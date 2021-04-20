package com.example.product.service;

import com.example.product.models.ParentCategory;

import java.util.List;

public interface ParentCategoryService {
    List<ParentCategory> getAll();
    ParentCategory getParentCategoryById(long id);
    void deleteAll();
    void deleteCategoryById(long id);

    ParentCategory addParentCategory(ParentCategory parentCategory);

    ParentCategory updateParentCategoy(long id, ParentCategory parentCategory);
}
