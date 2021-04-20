package com.example.product.service;

import com.example.product.models.Category;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category addCategory(Category category);
    void deleteAll();
    Category updateCategory(long id, Category category);
    void deleteCategory(long id);

    Category getCategoryById(Long categoryId);
}
