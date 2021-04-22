package com.example.product.service;

import com.example.product.models.Category;
import com.example.product.request.CategoryRequest;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> getAll();
    Category addCategory(CategoryRequest category);
    void deleteAll();
    Category updateCategory(long id, CategoryRequest category);
    void deleteCategory(long id);

    Category getCategoryById(Long categoryId);
}
